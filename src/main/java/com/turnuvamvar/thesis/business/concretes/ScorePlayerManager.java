package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.ScorePlayerDao;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.mapper.ScorePlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public DataResult<ScorePlayer> getOneScorePlayerById(Long scorePlayerId) {
        Optional<ScorePlayer> scorePlayer = this.scorePlayerDao.findById(scorePlayerId);
        if(scorePlayer.isPresent()){
            return new SuccessDataResult<ScorePlayer>(scorePlayer.get());
        }
        else{
            return new ErrorDataResult<ScorePlayer>("Score_player bulunamadı");
        }
    }

    @Override
    public DataResult<List<ScorePlayer>> getAllScorePlayers() {
        List<ScorePlayer> scorePlayerList = new ArrayList<>();
        Iterable<ScorePlayer> scorePlayerIterable = this.scorePlayerDao.findAll();
        scorePlayerIterable.iterator().forEachRemaining(scorePlayerList :: add);
        if(scorePlayerList.isEmpty()){
            return new ErrorDataResult<>("score_player listesinde hiç score_player bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<ScorePlayer>>(scorePlayerList);
        }
    }

    @Override
    public DataResult<ScorePlayerDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerDto scorePlayerDto) {
        return null;
    }

    @Override
    public Result deleteOneScorePlayerById(Long scorePlayerId) {
        Optional<ScorePlayer> scorePlayer = this.scorePlayerDao.findById(scorePlayerId);
        if(scorePlayer.isPresent()){
            this.scorePlayerDao.deleteById(scorePlayer.get().getId());
            return new SuccessResult("score_player silindi..");
        }
        else{
            return new ErrorResult("score_player bulunamadığı için silinemedi!");
        }
    }
}
