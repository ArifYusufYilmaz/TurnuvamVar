package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GamePerformedDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
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
    public void setGameToPlayDao(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }

    @Override
    public DataResult<GamePerformedResponseDto> createOneGamePerformed(GamePerformedResponseDto newGamePerformedResponseDto) {
        //hiç bir kontrol-işlem yapılmadı!!!
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(newGamePerformedResponseDto.getGameToPlayId());
        if(gameToPlay.isPresent()){
            GamePerformed gamePerformed = this.gamePerformedResponseMapper.mapGamePerformedResponseDtoToGamePerformed(newGamePerformedResponseDto);
            this.gamePerformedDao.save(gamePerformed);
            newGamePerformedResponseDto = this.gamePerformedResponseMapper.mapGamePerformedToGamePerformedResponseDto(gamePerformed);
            return new SuccessDataResult<GamePerformedResponseDto>(newGamePerformedResponseDto);
        }else{
            return new ErrorDataResult<GamePerformedResponseDto>("oynanacak maç bulunamadı..");
        }

    }

    @Override
    public DataResult<GamePerformed> getOneGamePerformedById(Long gamePerformedId) {
        Optional<GamePerformed> gamePerformed = this.gamePerformedDao.findById(gamePerformedId);
        if(gamePerformed.isPresent()){
            return new SuccessDataResult<GamePerformed>(gamePerformed.get());
        }
        else{
            return new ErrorDataResult<GamePerformed>("oynanan oyun bulunamadı");
        }
    }

    @Override
    public DataResult<GamePerformedResponseDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedResponseDto gamePerformedResponseDto) {
        return null;
    }

    @Override
    public DataResult<List<GamePerformed>> getAllGamesPerformed() {
        List<GamePerformed> gamePerformedList = new ArrayList<>();
        Iterable<GamePerformed> gamePerformedIterable = this.gamePerformedDao.findAll();
        gamePerformedIterable.iterator().forEachRemaining(gamePerformedList :: add);
        if(gamePerformedList.isEmpty()){
            return new ErrorDataResult<>("stage listesinde hiç stage bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<GamePerformed>>(gamePerformedList);
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
