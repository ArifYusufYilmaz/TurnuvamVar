package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.PlayerDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.ScoreDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.ScorePlayerDao;
import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import com.turnuvamvar.thesis.mapper.Request.ScorePlayerRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.ScorePlayerResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ScorePlayerManager implements ScorePlayerService {
    @Autowired
    private ScorePlayerDao scorePlayerDao;
    private ScorePlayerResponseMapper scorePlayerResponseMapper;
    private ScorePlayerRequestMapper scorePlayerRequestMapper;
    private PlayerDao playerDao;
    private ScoreDao scoreDao;
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
    @Autowired
    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    @Autowired
    public void setScoreDao(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    @Override
    public DataResult<ScorePlayerResponseDto> createOneScorePlayer(ScorePlayerRequestDto newScorePlayerRequestDto) {
        // kontroller! öyle bir oyuncu var mı vs.
        Optional<Player> player = this.playerDao.findById(newScorePlayerRequestDto.getPlayerId());
        Optional<Score> score = this.scoreDao.findById(newScorePlayerRequestDto.getScoreId());
        if(newScorePlayerRequestDto != null){
            if(player.isPresent() && score.isPresent()){
                ScorePlayer scorePlayer = this.scorePlayerRequestMapper.mapScorePlayerRequestDtoToScorePlayer(newScorePlayerRequestDto);
                scorePlayer.setPlayer(player.get());
                scorePlayer.setScore(score.get());
                scorePlayer = this.scorePlayerDao.save(scorePlayer);
                ScorePlayerResponseDto scorePlayerResponseDto = this.scorePlayerResponseMapper.mapScorePlayerToScorePlayerResponseDto(scorePlayer);
                return new SuccessDataResult<ScorePlayerResponseDto>(scorePlayerResponseDto);
            }else{
                return new ErrorDataResult<ScorePlayerResponseDto>("oyuncu ya da score bulunamadı..");
            }

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
    public DataResult<ScorePlayerResponseDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerRequestDto scorePlayerRequestDto) {
        Optional<ScorePlayer> scorePlayer = this.scorePlayerDao.findById(scorePlayerId);
        Optional<Player> player = this.playerDao.findById(scorePlayerRequestDto.getPlayerId());
        Optional<Score> score = this.scoreDao.findById(scorePlayerRequestDto.getScoreId());
        if(scorePlayer.isPresent()){
            if(player.isPresent() && score.isPresent()){
                ScorePlayer toSave = scorePlayer.get();
                toSave.setPlayer(player.get());
                toSave.setScore(score.get());
                toSave = this.scorePlayerDao.save(toSave);
                ScorePlayerResponseDto scorePlayerResponseDto = this.scorePlayerResponseMapper.mapScorePlayerToScorePlayerResponseDto(toSave);
                return new SuccessDataResult<ScorePlayerResponseDto>(scorePlayerResponseDto);
            }
            else{
                return new ErrorDataResult<ScorePlayerResponseDto>("oyuncu ya da score bulunamadı..");
            }

        }
        else{
            return new ErrorDataResult<ScorePlayerResponseDto>("ScorePlayer bulunamadı..");
        }
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
