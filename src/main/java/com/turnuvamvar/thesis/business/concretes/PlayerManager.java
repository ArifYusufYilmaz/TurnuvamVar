package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
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
    public void setPlayerToAddDao(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }

    @Override
    public DataResult<Player> createOnePlayer(Long playerToAddDtoId) {   //admin id, playerToAdd id gelmeli.

        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddDtoId);
        if(playerToAdd.isPresent()){
            PlayerToAddResponseDto playerToAddResponseDto = this.playerToAddResponseMapper.mapPlayerToAddToPlayerToAddResponseDto(playerToAdd.get());
            Player player = this.playerResponseMapper.mapPlayerToAddResponseDtoToPlayer(playerToAddResponseDto);
            player.setTeam(playerToAdd.get().getTeam());
            // oyuncu eklendiği zaman eklenecek oyuncu listesindekinin silinmesi lazım!!!!!!!
            // aynı şekilde reddedilse de ordan silinmesi lazım.
            return new SuccessDataResult<Player>(this.playerDao.save(player));
        }
        else {
            return new ErrorDataResult<Player>("bulunamadı");
        }
    }



    @Override
    public DataResult<Player> getOnePlayerById(Long playerId) {
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            return new SuccessDataResult<Player>(player.get());
        }
        else{
            return new ErrorDataResult<Player>("Oyuncu bulunamadı");
        }
    }

    @Override
    public DataResult<PlayerResponseDto> updateOnePlayer(Long playerId, PlayerResponseDto playerResponseDto) { // fix
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            Player toSave = player.get();
            toSave.setPlayerFirstName(playerResponseDto.getPlayerFirstName());
            toSave.setPlayerLastName(playerResponseDto.getPlayerLastName());
            // playerdto da id alıyorum adres veya telefon değil bunu fixle.
            //toSave.getPlayerCommunication().setPlayerPhoneNumber();
            toSave.setPosition(playerResponseDto.getPosition());

            toSave = this.playerDao.save(toSave);
          //  PlayerResponseDto newPlayerDto = playerResponseMapper.(toSave);newPlayerDto
              return new SuccessDataResult<PlayerResponseDto>();
        }
        else{
            return new ErrorDataResult<PlayerResponseDto>("oyuncu bulunamadı..");
        }
    }

    @Override
    public DataResult<List<Player>> getAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        Iterable<Player> playerIterable = this.playerDao.findAll();
        playerIterable.iterator().forEachRemaining(playerList :: add);
        if(playerList.isEmpty()){
            return new ErrorDataResult<>("stage listesinde hiç stage bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<Player>>(playerList);
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
            return new ErrorResult("player bulunamadığı için silinemedi!");
        }
    }
}
