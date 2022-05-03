package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.ScorePlayerDao;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import com.turnuvamvar.thesis.mapper.ScorePlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScorePlayerManager implements ScorePlayerService {
    @Autowired
    private ScorePlayerDao scorePlayerDao;
    private ScorePlayerMapper scorePlayerMapper;
    @Autowired
    public ScorePlayerManager(ScorePlayerDao scorePlayerDao) {
        this.scorePlayerDao = scorePlayerDao;
    }
    @Autowired
    public void setScorePlayerMapper(ScorePlayerMapper scorePlayerMapper) {
        this.scorePlayerMapper = scorePlayerMapper;
    }

    @Override
    public DataResult<ScorePlayerDto> createOneScorePlayer(ScorePlayerDto newScorePlayerDto) {
       ScorePlayer scorePlayer =  this.scorePlayerMapper.mapScorePlayerDtoToScorePlayer(newScorePlayerDto);
       ScorePlayerDto scorePlayerDto =  this.scorePlayerMapper.mapScorePlayerToScorePlayerDto(this.scorePlayerDao.save(scorePlayer));
       return new SuccessDataResult<ScorePlayerDto>(scorePlayerDto);
    }
}
