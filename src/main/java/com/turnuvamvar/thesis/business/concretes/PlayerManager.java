package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dto.Request.PlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.mapper.Request.PlayerRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.PlayerResponseMapper;
import com.turnuvamvar.thesis.mapper.Response.PlayerToAddResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerManager implements PlayerService {
    @Autowired
    private PlayerDao playerDao;
    private PlayerToAddDao playerToAddDao;
    private PlayerResponseMapper playerResponseMapper;
    private PlayerRequestMapper playerRequestMapper;
    private PlayerToAddResponseMapper playerToAddResponseMapper;
    @Autowired
    public PlayerManager(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    @Autowired
    public void setPlayerResponseMapper(PlayerResponseMapper playerResponseMapper) {
        this.playerResponseMapper = playerResponseMapper;
    }
    @Autowired
    public void setPlayerToAddResponseMapper(PlayerToAddResponseMapper playerToAddResponseMapper) {
        this.playerToAddResponseMapper = playerToAddResponseMapper;
    }
    @Autowired
    public void setPlayerRequestMapper(PlayerRequestMapper playerRequestMapper) {
        this.playerRequestMapper = playerRequestMapper;
    }

    @Autowired
    public void setPlayerToAddDao(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }

    @Override
    public DataResult<PlayerResponseDto> createOnePlayer(Long playerToAddDtoId) {   //admin id, playerToAdd id gelmeli.

        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddDtoId);
        if(playerToAdd.isPresent()){
            PlayerToAddResponseDto playerToAddResponseDto = this.playerToAddResponseMapper.mapPlayerToAddToPlayerToAddResponseDto(playerToAdd.get());
            Player player = this.playerResponseMapper.mapPlayerToAddResponseDtoToPlayer(playerToAddResponseDto);
            player.setTeam(playerToAdd.get().getTeam());
            // oyuncu eklendi??i zaman eklenecek oyuncu listesindekinin silinmesi laz??m!!!!!!!
            // ayn?? ??ekilde reddedilse de ordan silinmesi laz??m.
            player = this.playerDao.save(player);
            PlayerResponseDto playerResponseDto = this.playerResponseMapper.mapPlayerToPlayerResponseDto(player);
            return new SuccessDataResult<PlayerResponseDto>(playerResponseDto);
        }
        else {
            return new ErrorDataResult<PlayerResponseDto>("bulunamad??");
        }
    }



    @Override
    public DataResult<PlayerResponseDto> getOnePlayerById(Long playerId) {
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            PlayerResponseDto playerResponseDto = this.playerResponseMapper.mapPlayerToPlayerResponseDto(player.get());
            return new SuccessDataResult<PlayerResponseDto>(playerResponseDto);
        }
        else{
            return new ErrorDataResult<PlayerResponseDto>("Oyuncu bulunamad??");
        }
    }

    @Override
    public DataResult<PlayerResponseDto> updateOnePlayer(Long playerId, PlayerRequestDto playerRequestDto) { // fix
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            //this.playerRequestMapper.mapPlayerToAddRequestDtoToPlayer();
            Player toSave = player.get();
            toSave.setPlayerFirstName(playerRequestDto.getPlayerFirstName());
            toSave.setPlayerLastName(playerRequestDto.getPlayerLastName());
            toSave.setPosition(playerRequestDto.getPosition());
            toSave.getPlayerCommunication().setPlayerAddress(playerRequestDto.getPlayerAddress());
            toSave.getPlayerCommunication().setPlayerPhoneNumber(playerRequestDto.getPlayerPhoneNumber());
            // playerdto da id al??yorum adres veya telefon de??il bunu fixle.
            //toSave.getPlayerCommunication().setPlayerPhoneNumber();

            toSave = this.playerDao.save(toSave);
            PlayerResponseDto playerResponseDto =this.playerResponseMapper.mapPlayerToPlayerResponseDto(toSave);
              return new SuccessDataResult<PlayerResponseDto>(playerResponseDto);
        }
        else{
            return new ErrorDataResult<PlayerResponseDto>("G??ncellenmek istenen oyuncu bulunamad??..");
        }
    }

    @Override
    public DataResult<List<PlayerResponseDto>> getAllPlayers(Long teamId) {
        List<Player> playerList = new ArrayList<>();
        Iterable<Player> playerIterable = this.playerDao.findAll();
        playerIterable.iterator().forEachRemaining(playerList :: add);
        if(playerList.isEmpty()){
            return new ErrorDataResult<PlayerResponseDto>("stage listesinde hi?? stage bulunamad??!");
        }
        else{
            List<PlayerResponseDto> playerResponseDtoList = this.playerResponseMapper.mapPlayerListToPlayerResponseDtoList(playerList);
            return new SuccessDataResult<List<PlayerResponseDto>>(playerResponseDtoList);
        }
    }

    @Override
    public Result deleteOnePlayerById(Long playerId) {
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            this.playerDao.deleteById(player.get().getId());
            return new SuccessResult("player silindi..");
        }
        else{
            return new ErrorResult("player bulunamad?????? i??in silinemedi!");
        }
    }
}
