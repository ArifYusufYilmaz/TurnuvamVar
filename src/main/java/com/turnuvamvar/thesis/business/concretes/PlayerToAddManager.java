package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.ErrorDataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerToAddDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamCaptainDao;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import com.turnuvamvar.thesis.entities.concretes.TeamCaptain;
import com.turnuvamvar.thesis.mapper.PlayerToAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerToAddManager implements PlayerToAddService {
    @Autowired
    private PlayerToAddDao playerToAddDao;
    private PlayerToAddMapper playerToAddMapper;
    private TeamCaptainDao teamCaptainDao;      //bu service seviyesinde olmalı. diğer metodlar yazılınca düzelt!!!
    @Autowired
    public PlayerToAddManager(PlayerToAddDao playerToAddDao) {
        this.playerToAddDao = playerToAddDao;
    }
    @Autowired
    public void setPlayerToAddMapper(@Lazy PlayerToAddMapper playerToAddMapper) {
        this.playerToAddMapper = playerToAddMapper;
    }
    @Autowired
    public void setTeamCaptainDao(TeamCaptainDao teamCaptainDao) {
        this.teamCaptainDao = teamCaptainDao;
    }

    @Override
    public DataResult<PlayerToAddDto> createOnePlayerToAdd(Long teamCaptainId,PlayerToAddDto newPlayerToAddDto) {
        Optional<TeamCaptain> teamCaptain = this.teamCaptainDao.findById(teamCaptainId);
        if(teamCaptain.isPresent()){
            PlayerToAdd playerToAdd = playerToAddMapper.mapPlayerToAddDtoToPlayerToAdd(newPlayerToAddDto);
            playerToAdd.setTeam(teamCaptain.get().getTeam());
            newPlayerToAddDto = playerToAddMapper.mapPlayerToAddToPlayerToAddDto(this.playerToAddDao.save(playerToAdd));
            return new SuccessDataResult<PlayerToAddDto>(newPlayerToAddDto);
        }
        else{
            return new ErrorDataResult<PlayerToAddDto>("takım kaptanı dışında kimse oyuncu ekleyemez, takım kaptanı bulunamadı");
        }
    }
}
