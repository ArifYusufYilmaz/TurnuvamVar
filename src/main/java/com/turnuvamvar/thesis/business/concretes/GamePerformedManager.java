package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GamePerformedDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dto.Request.GamePerformedRequestDto;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.mapper.Request.GamePerformedRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.GamePerformedResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GamePerformedManager implements GamePerformedService {
    @Autowired
    private GamePerformedDao gamePerformedDao;
    private GamePerformedResponseMapper gamePerformedResponseMapper;
    private GamePerformedRequestMapper gamePerformedRequestMapper;
    private GameToPlayDao gameToPlayDao;
    @Autowired
    public GamePerformedManager(GamePerformedDao gamePerformedDao) {
        this.gamePerformedDao = gamePerformedDao;
    }
    @Autowired
    public void setGamePerformedResponseMapper(GamePerformedResponseMapper gamePerformedResponseMapper) {
        this.gamePerformedResponseMapper = gamePerformedResponseMapper;
    }
    @Autowired
    public void setGamePerformedRequestMapper(GamePerformedRequestMapper gamePerformedRequestMapper) {
        this.gamePerformedRequestMapper = gamePerformedRequestMapper;
    }

    @Autowired
    public void setGameToPlayDao(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }

    @Override
    public DataResult<GamePerformedResponseDto> createOneGamePerformed(GamePerformedRequestDto newGamePerformedRequestDto) {
        //hiç bir kontrol-işlem yapılmadı!!!
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(newGamePerformedRequestDto.getGameToPlayId());
        if(gameToPlay.isPresent()){
            GamePerformed gamePerformed = this.gamePerformedRequestMapper.mapGamePerformedRequestDtoToGamePerformed(newGamePerformedRequestDto);
            gamePerformed.getGameToPlay().setStageTeamFirst(gameToPlay.get().getStageTeamFirst());
            gamePerformed.getGameToPlay().setStageTeamSecond(gameToPlay.get().getStageTeamSecond());
            gamePerformed = this.gamePerformedDao.save(gamePerformed);
            GamePerformedResponseDto newGamePerformedResponseDto = this.gamePerformedResponseMapper.mapGamePerformedToGamePerformedResponseDto(gamePerformed);
            return new SuccessDataResult<GamePerformedResponseDto>(newGamePerformedResponseDto);
        }else{
            return new ErrorDataResult<GamePerformedResponseDto>("oynanacak maç bulunamadı..");
        }

    }

    @Override
    public DataResult<GamePerformedResponseDto> getOneGamePerformedById(Long gamePerformedId) {
        Optional<GamePerformed> gamePerformed = this.gamePerformedDao.findById(gamePerformedId);
        if(gamePerformed.isPresent()){
            GamePerformedResponseDto gamePerformedResponseDto = this.gamePerformedResponseMapper.mapGamePerformedToGamePerformedResponseDto(gamePerformed.get());
            return new SuccessDataResult<GamePerformedResponseDto>(gamePerformedResponseDto);
        }
        else{
            return new ErrorDataResult<GamePerformedResponseDto>("oynanan oyun bulunamadı");
        }
    }

    @Override
    public DataResult<GamePerformedResponseDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedRequestDto gamePerformedRequestDto) {
        Optional<GamePerformed> gamePerformed = this.gamePerformedDao.findById(gamePerformedId);
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gamePerformedRequestDto.getGameToPlayId());
        if(gamePerformed.isPresent()){
            if(gameToPlay.isPresent() && (gameToPlay.get().getId() == gamePerformed.get().getId())){
                GamePerformed toSave = gamePerformed.get();
                toSave.getScoreOfFirstTeam().setScore(gamePerformedRequestDto.getScoreOfFirstTeam());
                toSave.getScoreOfSecondTeam().setScore(gamePerformedRequestDto.getScoreOfSecondTeam());
                toSave = this.gamePerformedDao.save(toSave);
                GamePerformedResponseDto gamePerformedResponseDto = this.gamePerformedResponseMapper.mapGamePerformedToGamePerformedResponseDto(toSave);
                return new SuccessDataResult<GamePerformedResponseDto>(gamePerformedResponseDto);
            }else{
                return new ErrorDataResult<GamePerformedResponseDto>("Oynanacak oyun mevcut olmalı ve farklı verilmemeli..");
            }
        }else{
            return new ErrorDataResult<GamePerformedResponseDto>("Güncellenmek istenen Oynanan Oyun bulunamadı..");
        }

    }

    @Override
    public DataResult<List<GamePerformedResponseDto>> getAllGamesPerformed() {
        List<GamePerformed> gamePerformedList = new ArrayList<>();
        Iterable<GamePerformed> gamePerformedIterable = this.gamePerformedDao.findAll();
        gamePerformedIterable.iterator().forEachRemaining(gamePerformedList :: add);
        if(gamePerformedList.isEmpty()){
            return new ErrorDataResult<GamePerformedResponseDto>("Oynanan oyun listesinde hiç oyun bulunamadı!");
        }
        else{
            List<GamePerformedResponseDto> gamePerformedResponseDtoList = this.gamePerformedResponseMapper.mapGamePerformedListToGamePerformedResponseList(gamePerformedList);
            return new SuccessDataResult<List<GamePerformedResponseDto>>(gamePerformedResponseDtoList);
        }
    }

    @Override
    public Result deleteOneGamePerformedById(Long gamePerformedId) {
        Optional<GamePerformed> gamePerformed = this.gamePerformedDao.findById(gamePerformedId);
        if(gamePerformed.isPresent()){
            this.gamePerformedDao.deleteById(gamePerformed.get().getId());
            return new SuccessResult("oynanan oyun silindi..");
        }
        else{
            return new ErrorResult("oynanan oyun bulunamadığı için silinemedi!");
        }
    }
}
