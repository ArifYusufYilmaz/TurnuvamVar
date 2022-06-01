package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.ScorePlayerDao;
import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import com.turnuvamvar.thesis.mapper.Request.ScorePlayerRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.ScorePlayerResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScorePlayerManager implements ScorePlayerService {
    @Autowired
    private ScorePlayerDao scorePlayerDao;
    private ScorePlayerResponseMapper scorePlayerResponseMapper;
    private ScorePlayerRequestMapper scorePlayerRequestMapper;
    @Autowired
    public ScorePlayerManager(ScorePlayerDao scorePlayerDao) {
        this.scorePlayerDao = scorePlayerDao;
    }
    @Autowired
    public void setScorePlayerResponseMapper(ScorePlayerResponseMapper scorePlayerResponseMapper) {
        this.scorePlayerResponseMapper = scorePlayerResponseMapper;
    }
    @Autowired
    public void setScorePlayerRequestMapper(ScorePlayerRequestMapper scorePlayerRequestMapper) {
        this.scorePlayerRequestMapper = scorePlayerRequestMapper;
    }

    @Override
    public DataResult<ScorePlayerResponseDto> createOneScorePlayer(ScorePlayerRequestDto newScorePlayerRequestDto) {
        // kontroller! öyle bir oyuncu var mı vs.
        if(newScorePlayerRequestDto == null){
            ScorePlayer scorePlayer = this.scorePlayerRequestMapper.mapScorePlayerRequestDtoToScorePlayer(newScorePlayerRequestDto);
            // setlemek gereken bir şey var mı!
            scorePlayer = this.scorePlayerDao.save(scorePlayer);
            ScorePlayerResponseDto scorePlayerResponseDto = this.scorePlayerResponseMapper.mapScorePlayerToScorePlayerResponseDto(scorePlayer);
            return new SuccessDataResult<ScorePlayerResponseDto>(scorePlayerResponseDto);
        }else{
            return new ErrorDataResult<ScorePlayerResponseDto>("istek null");
        }
    }

    @Override
    public DataResult<ScorePlayerResponseDto> getOneScorePlayerById(Long scorePlayerId) {
        Optional<ScorePlayer> scorePlayer = this.scorePlayerDao.findById(scorePlayerId);
        if(scorePlayer.isPresent()){
            ScorePlayerResponseDto scorePlayerResponseDto = this.scorePlayerResponseMapper.mapScorePlayerToScorePlayerResponseDto(scorePlayer.get());
            return new SuccessDataResult<ScorePlayerResponseDto>(scorePlayerResponseDto);
        }
        else{
            return new ErrorDataResult<ScorePlayerResponseDto>("Score_player bulunamadı");
        }
    }

    @Override
    public DataResult<List<ScorePlayerResponseDto>> getAllScorePlayers() {
        List<ScorePlayer> scorePlayerList = new ArrayList<>();
        Iterable<ScorePlayer> scorePlayerIterable = this.scorePlayerDao.findAll();
        scorePlayerIterable.iterator().forEachRemaining(scorePlayerList :: add);
        if(scorePlayerList.isEmpty()){
            return new ErrorDataResult<ScorePlayerResponseDto>("score_player listesinde hiç score_player bulunamadı!");
        }
        else{
            List<ScorePlayerResponseDto> scorePlayerResponseDtoList = this.scorePlayerResponseMapper.mapScorePlayerListToScorePlayerResponseDtoList(scorePlayerList);
            return new SuccessDataResult<List<ScorePlayerResponseDto>>(scorePlayerResponseDtoList);
        }
    }

    @Override
    public DataResult<ScorePlayerResponseDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerRequestDto scorePlayerResponseDto) {
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
