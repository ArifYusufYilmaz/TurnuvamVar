package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.mapper.GameToPlayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameToPlayManager implements GameToPlayService {
    @Autowired
    private GameToPlayDao gameToPlayDao;
    private GameToPlayMapper gameToPlayMapper;
    @Autowired
    public GameToPlayManager(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }
    @Autowired
    public void setGameToPlayMapper(GameToPlayMapper gameToPlayMapper) {
        this.gameToPlayMapper = gameToPlayMapper;
    }

    @Override
    public DataResult<GameToPlayDto> createOneGameToPlay(GameToPlayDto newGameToPlayDto) {
        //kontrolleri yapmalısın!!
        GameToPlay newGameToPlay = this.gameToPlayMapper.mapGameToPlayDtoToGameToPlay(newGameToPlayDto);
        this.gameToPlayDao.save(newGameToPlay);
        newGameToPlayDto = this.gameToPlayMapper.mapGameToPlayToGameToPlayDto(newGameToPlay);
        return new SuccessDataResult<GameToPlayDto>(newGameToPlayDto);
    }
}
