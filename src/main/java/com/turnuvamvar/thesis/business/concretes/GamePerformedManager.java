package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.GamePerformedDao;
import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.mapper.GamePerformedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamePerformedManager implements GamePerformedService {
    @Autowired
    private GamePerformedDao gamePerformedDao;
    private GamePerformedMapper gamePerformedMapper;
    @Autowired
    public GamePerformedManager(GamePerformedDao gamePerformedDao) {
        this.gamePerformedDao = gamePerformedDao;
    }
    @Autowired
    public void setGamePerformedMapper(GamePerformedMapper gamePerformedMapper) {
        this.gamePerformedMapper = gamePerformedMapper;
    }

    @Override
    public DataResult<GamePerformedDto> createOneGamePerformed(GamePerformedDto newGamePerformedDto) {
        //hiç bir kontrol-işlem yapılmadı!!!
        GamePerformed gamePerformed = this.gamePerformedMapper.mapGamePerformedDtoToGamePerformed(newGamePerformedDto);
        this.gamePerformedDao.save(gamePerformed);
        newGamePerformedDto = this.gamePerformedMapper.mapGamePerformedToGamePerformedDto(gamePerformed);
        return new SuccessDataResult<GamePerformedDto>(newGamePerformedDto);
    }
}
