package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.mapper.Response.PlayerToAddResponseMapper;
import com.turnuvamvar.thesis.mapper.Request.PlayerToAddRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerToAddManager implements PlayerToAddService {
    @Autowired
    private PlayerToAddDao playerToAddDao;
    private PlayerToAddResponseMapper playerToAddResponseMapper;
    private PlayerToAddRequestMapper playerToAddRequestMapper;
    private TeamDao teamDao;      //bu service seviyesinde olmalı. diğer metodlar yazılınca düzelt!!!

    @Autowired
    public PlayerToAddManager(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }
    @Autowired
    public void setPlayerToAddResponseMapper(@Lazy PlayerToAddResponseMapper playerToAddResponseMapper) {
        this.playerToAddResponseMapper = playerToAddResponseMapper;
    }
    @Autowired
    public void setPlayerToAddRequestMapper(PlayerToAddRequestMapper playerToAddRequestMapper) {
        this.playerToAddRequestMapper = playerToAddRequestMapper;
    }

    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public DataResult<PlayerToAddResponseDto> createOnePlayerToAdd(Long teamId, PlayerToAddRequestDto newPlayerToAddRequestDto) {

        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            PlayerToAdd playerToAdd = this.playerToAddRequestMapper.mapPlayerToAddRequestDtoToPlayerToAdd(newPlayerToAddRequestDto);
            playerToAdd.setTeam(team.get());
            playerToAdd = this.playerToAddDao.save(playerToAdd);
            PlayerToAddResponseDto newPlayerToAddResponseDto = playerToAddResponseMapper.mapPlayerToAddToPlayerToAddResponseDto(playerToAdd);
            return new SuccessDataResult<PlayerToAddResponseDto>(newPlayerToAddResponseDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddResponseDto>("  takım  bulunamadı");
        }
    }

    @Override
    public DataResult<PlayerToAddResponseDto> updateOnePlayerToAdd(Long playerToAddId, PlayerToAddRequestDto playerToAddRequestDto) {
        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddId);
        if(playerToAdd.isPresent()){
            PlayerToAdd toSave = playerToAdd.get();
            toSave.setPlayerFirstName(playerToAddRequestDto.getPlayerFirstName());
            toSave.setPlayerLastName(playerToAddRequestDto.getPlayerLastName());
            toSave.setPosition(playerToAddRequestDto.getPosition());
            toSave.setPlayerAddress(playerToAddRequestDto.getPlayerAddress());
            toSave.setPlayerPhoneNumber(playerToAddRequestDto.getPlayerPhoneNumber());
            toSave = this.playerToAddDao.save(toSave);
            PlayerToAddResponseDto playerToAddResponseDto = playerToAddResponseMapper.mapPlayerToAddToPlayerToAddResponseDto(toSave);
            return new SuccessDataResult<PlayerToAddResponseDto>(playerToAddResponseDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddResponseDto>("güncellenmek istenen \"eklenecek oyuncu\" bulunamadı.!!");
        }

    }

    @Override
    public DataResult<PlayerToAddResponseDto> getOnePlayerToAddById(Long playerToAddId) {
        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddId);
        if(playerToAdd.isPresent()){
            PlayerToAddResponseDto playerToAddResponseDto = this.playerToAddResponseMapper.mapPlayerToAddToPlayerToAddResponseDto(playerToAdd.get());
            return new SuccessDataResult<PlayerToAddResponseDto>(playerToAddResponseDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddResponseDto>("istenen 'eklenecek oyuncu' bulunamadı!! ");
        }

    }

    @Override
    public DataResult<List<PlayerToAddResponseDto>> getAllPlayersToAdd(Long teamId) {
        // hangi takım oldugunu al.
        List<PlayerToAdd> playerToAddList = new ArrayList<>();
        Iterable<PlayerToAdd> playerToAddIterable;
        if(teamId == null){
            playerToAddIterable = this.playerToAddDao.findAll();

        }else{
            playerToAddIterable = this.playerToAddDao.findAllByTeamId(teamId);

        }
        playerToAddIterable.iterator().forEachRemaining(playerToAddList :: add);
        if(playerToAddList.isEmpty()){
            return new ErrorDataResult<PlayerToAddResponseDto>("eklenecek oyuncu listesinde hiç veri bulunamadı!");
        }
        else {
            List<PlayerToAddResponseDto> playerToAddResponseDtoList = this.playerToAddResponseMapper.mapPlayerToAddListToPlayerToAddResponseDtoList(playerToAddList);
            return new SuccessDataResult<List<PlayerToAddResponseDto>>(playerToAddResponseDtoList);
        }
    }

    @Override
    public Result deleteOnePlayerToAddById(Long playerToAddId) {
        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddId);
        if(playerToAdd.isPresent()){
            this.playerToAddDao.deleteById(playerToAdd.get().getId());
            return new SuccessResult("'eklenecek oyuncu' silindi!");
        }
        else{

            return new ErrorResult("silinmek istenen 'eklenecek oyuncu' bulunamadı");
        }
    }
}
