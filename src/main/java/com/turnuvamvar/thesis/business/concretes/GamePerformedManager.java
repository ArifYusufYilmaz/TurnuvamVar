package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GamePerformedDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.mapper.GamePerformedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GamePerformedManager implements GamePerformedService {
    @Autowired
    private GamePerformedDao gamePerformedDao;
    private GamePerformedMapper gamePerformedMapper;
    private GameToPlayDao gameToPlayDao;
    @Autowired
    public GamePerformedManager(GamePerformedDao gamePerformedDao) {
        this.gamePerformedDao = gamePerformedDao;
    }
    @Autowired
    public void setGamePerformedMapper(GamePerformedMapper gamePerformedMapper) {
        this.gamePerformedMapper = gamePerformedMapper;
    }
    @Autowired
    public void setGameToPlayDao(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }

    @Override
    public DataResult<GamePerformedDto> createOneGamePerformed(GamePerformedDto newGamePerformedDto) {
        //hiç bir kontrol-işlem yapılmadı!!!
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(newGamePerformedDto.getGameToPlayId());
        if(gameToPlay.isPresent()){
            GamePerformed gamePerformed = this.gamePerformedMapper.mapGamePerformedDtoToGamePerformed(newGamePerformedDto);
            this.gamePerformedDao.save(gamePerformed);
            newGamePerformedDto = this.gamePerformedMapper.mapGamePerformedToGamePerformedDto(gamePerformed);
            return new SuccessDataResult<GamePerformedDto>(newGamePerformedDto);
        }else{
            return new ErrorDataResult<GamePerformedDto>("oynanacak maç bulunamadı..");
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
    public DataResult<GamePerformedDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedDto gamePerformedDto) {
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
