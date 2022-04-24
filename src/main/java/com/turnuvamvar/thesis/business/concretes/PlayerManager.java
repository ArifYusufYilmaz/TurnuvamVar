package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.ErrorDataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.mapper.PlayerMapper;
import com.turnuvamvar.thesis.mapper.PlayerToAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            // oyuncu eklendiği zaman eklenecek oyuncu listesindekinin silinmesi lazım!!!!!!!
            return new SuccessDataResult<Player>(this.playerDao.save(player));
        }
        else {
            return new ErrorDataResult<Player>("bulunamadı");
        }
    }
}
