package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamCaptainDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.TeamCaptain;
import com.turnuvamvar.thesis.mapper.PlayerToAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerToAddManager implements PlayerToAddService {
    @Autowired
    private PlayerToAddDao playerToAddDao;
    private PlayerToAddMapper playerToAddMapper;
    private TeamDao teamDao;      //bu service seviyesinde olmalı. diğer metodlar yazılınca düzelt!!!

    @Autowired
    public PlayerToAddManager(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }
    @Autowired
    public void setPlayerToAddMapper(@Lazy PlayerToAddMapper playerToAddMapper) {
        this.playerToAddMapper = playerToAddMapper;
    }
    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public DataResult<PlayerToAddDto> createOnePlayerToAdd(Long teamId,PlayerToAddDto newPlayerToAddDto) {

        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            PlayerToAdd playerToAdd = playerToAddMapper.mapPlayerToAddDtoToPlayerToAdd(newPlayerToAddDto);
            playerToAdd.setTeam(team.get());
            newPlayerToAddDto = playerToAddMapper.mapPlayerToAddToPlayerToAddDto(this.playerToAddDao.save(playerToAdd));
            return new SuccessDataResult<PlayerToAddDto>(newPlayerToAddDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddDto>("  takım  bulunamadı");
        }
    }

    @Override
    public DataResult<PlayerToAddDto> updateOnePlayerToAdd(Long playerToAddId, PlayerToAddDto playerToAddDto) {
        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddId);
        if(playerToAdd.isPresent()){
            PlayerToAdd toSave = playerToAdd.get();
            toSave.setPlayerFirstName(playerToAddDto.getPlayerFirstName());
            toSave.setPlayerLastName(playerToAddDto.getPlayerLastName());
            toSave.setPosition(playerToAddDto.getPosition());
            toSave.setPlayerAddress(playerToAddDto.getPlayerAddress());
            toSave.setPlayerPhoneNumber(playerToAddDto.getPlayerPhoneNumber());
            toSave = this.playerToAddDao.save(toSave);
            playerToAddDto = playerToAddMapper.mapPlayerToAddToPlayerToAddDto(toSave);
            return new SuccessDataResult<PlayerToAddDto>(playerToAddDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddDto>("güncellenmek istenen \"eklenecek oyuncu\" bulunamadı.!!");
        }

    }

    @Override
    public DataResult<PlayerToAdd> getOnePlayerToAddById(Long playerToAddId) {
        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddId);
        if(playerToAdd.isPresent()){
            return new SuccessDataResult<PlayerToAdd>(playerToAdd.get());
        }
        else{
            return new ErrorDataResult<PlayerToAdd>("istenen 'eklenecek oyuncu' bulunamadı!! ");
        }

    }

    @Override
    public DataResult<List<PlayerToAdd>> getAllPlayersToAdd() {
        List<PlayerToAdd> playerToAddList = new ArrayList<>();
        Iterable<PlayerToAdd> playerToAddIterable = this.playerToAddDao.findAll();
        playerToAddIterable.iterator().forEachRemaining(playerToAddList :: add);
        if(playerToAddList.isEmpty()){
            return new ErrorDataResult<>("eklenecek oyuncu listesinde hiç veri bulunamadı!");
        }
        else {
            return new SuccessDataResult<List<PlayerToAdd>>(playerToAddList);
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
