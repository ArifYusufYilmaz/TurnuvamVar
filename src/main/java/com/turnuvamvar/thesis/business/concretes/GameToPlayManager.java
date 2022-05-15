package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.mapper.GameToPlayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameToPlayManager implements GameToPlayService {
    @Autowired
    private GameToPlayDao gameToPlayDao;
    private GameToPlayMapper gameToPlayMapper;
    private TeamDao teamDao;    // gereksizse sil.
    private StageTeamDao stageTeamDao;
    @Autowired
    public GameToPlayManager(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }
    @Autowired
    public void setGameToPlayMapper(GameToPlayMapper gameToPlayMapper) {
        this.gameToPlayMapper = gameToPlayMapper;
    }
    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    @Autowired
    public void setStageTeamDao(StageTeamDao stageTeamDao) {
        this.stageTeamDao = stageTeamDao;
    }

    @Override
    public DataResult<GameToPlayDto> createOneGameToPlay(GameToPlayDto newGameToPlayDto) {
        //kontrolleri yapmalısın!!
        Optional<StageTeam> firstStageTeam = this.stageTeamDao.findById(newGameToPlayDto.getFirstTeamId());
        Optional<StageTeam> secondStageTeam = this.stageTeamDao.findById(newGameToPlayDto.getSecondTeamId());
        if(firstStageTeam.isPresent() && secondStageTeam.isPresent()){
            if(gameToPlayToCheckIfDuplicate(firstStageTeam.get().getId(), secondStageTeam.get().getId())){
                return new ErrorDataResult<GameToPlayDto>("aynı takımlar oynatılmak isteniyorsa takımlar yer değiştirmeli!");
            }else{
                GameToPlay newGameToPlay = this.gameToPlayMapper.mapGameToPlayDtoToGameToPlay(newGameToPlayDto);
                this.gameToPlayDao.save(newGameToPlay);
                newGameToPlayDto = this.gameToPlayMapper.mapGameToPlayToGameToPlayDto(newGameToPlay);
                return new SuccessDataResult<GameToPlayDto>(newGameToPlayDto);
            }
        }
        else{
            return new ErrorDataResult<GameToPlayDto>("Takımlar bulunamadı");
        }

    }

    @Override
    public DataResult<List<GameToPlay>> getAllGamesToPlay() {
        List<GameToPlay> gameToPlayList = new ArrayList<>();
        Iterable<GameToPlay> gameToPlayIterable = this.gameToPlayDao.findAll();
        gameToPlayIterable.iterator().forEachRemaining(gameToPlayList :: add);
        if(gameToPlayList.isEmpty()){
            return new ErrorDataResult<List<GameToPlay>>("oynanacak oyun  listesinde hiç stage bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<GameToPlay>>(gameToPlayList);
        }
    }

    @Override
    public DataResult<GameToPlay> getOneGameToPlayById(Long gameToPlayId) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            return new SuccessDataResult<GameToPlay>(gameToPlay.get());
        }
        else{
            return new ErrorDataResult<GameToPlay>("oynanacak maç bulunamadı");
        }
    }

    @Override
    public DataResult<GameToPlayDto> updateOneGameToPlay(Long gameToPlayId, GameToPlayDto gameToPlayDto) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            GameToPlay toSave = gameToPlay.get();
            toSave.getStageTeamFirst().setId(gameToPlayDto.getFirstTeamId());
            toSave.getStageTeamSecond().setId(gameToPlayDto.getSecondTeamId());
            toSave.setTarih(gameToPlayDto.getTarih());
            toSave = this.gameToPlayDao.save(toSave);
            GameToPlayDto newGameToPlayDto = gameToPlayMapper.mapGameToPlayToGameToPlayDto(toSave);
            return new SuccessDataResult<GameToPlayDto>(newGameToPlayDto);
        }
        else{
            return new ErrorDataResult<GameToPlayDto>("güncellenmek istenen oynanacak oyun bulunamadı..");
        }
    }

    @Override
    public Result deleteOneGameToPlayById(Long gameToPlayId) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            this.gameToPlayDao.deleteById(gameToPlay.get().getId());
            return new SuccessResult("oynanacak oyun silindi..");
        }
        else{
            return new ErrorResult("oynanacak oyun bulunamadığı için silinemedi!");
        }
    }
    private boolean gameToPlayToCheckIfDuplicate(Long firstStageTeamId, Long secondStageTeamId){
        GameToPlay gameToPlay = this.gameToPlayDao.findByStageTeamFirstIdAndStageTeamSecondId(firstStageTeamId, secondStageTeamId).orElse(null);
        return gameToPlay != null ? true : false;
    }
}
