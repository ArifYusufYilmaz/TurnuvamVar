package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dto.PlayerDto;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.mapper.PlayerMapper;
import com.turnuvamvar.thesis.mapper.PlayerToAddMapper;
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
    private PlayerMapper playerMapper;
    private PlayerToAddMapper playerToAddMapper;
    @Autowired
    public PlayerManager(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    @Autowired
    public void setPlayerMapper(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }
    @Autowired
    public void setPlayerToAddMapper(PlayerToAddMapper playerToAddMapper) {
        this.playerToAddMapper = playerToAddMapper;
    }
    @Autowired
    public void setPlayerToAddDao(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }

    @Override
    public DataResult<Player> createOnePlayer(Long playerToAddDtoId) {   //admin id, playerToAdd id gelmeli.

        Optional<PlayerToAdd> playerToAdd = this.playerToAddDao.findById(playerToAddDtoId);
        if(playerToAdd.isPresent()){
            PlayerToAddDto playerToAddDto = this.playerToAddMapper.mapPlayerToAddToPlayerToAddDto(playerToAdd.get());
            Player player = this.playerMapper.mapPlayerToAddDtoToPlayer(playerToAddDto);
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
    public DataResult<PlayerDto> updateOnePlayer(Long playerId, PlayerDto playerDto) { // fix
        Optional<Player> player = this.playerDao.findById(playerId);
        if(player.isPresent()){
            Player toSave = player.get();
            toSave.setPlayerFirstName(playerDto.getPlayerFirstName());
            toSave.setPlayerLastName(playerDto.getPlayerLastName());
            // playerdto da id alıyorum adres veya telefon değil bunu fixle.
            //toSave.getPlayerCommunication().setPlayerPhoneNumber();
            toSave.setPosition(playerDto.getPosition());

            toSave = this.playerDao.save(toSave);
          //  PlayerDto newPlayerDto = playerMapper.(toSave);newPlayerDto
              return new SuccessDataResult<PlayerDto>();
        }
        else{
            return new ErrorDataResult<PlayerDto>("oyuncu bulunamadı..");
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
