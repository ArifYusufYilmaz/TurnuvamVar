package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.mapper.Response.GameToPlayResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameToPlayManager implements GameToPlayService {
    @Autowired
    private GameToPlayDao gameToPlayDao;
    private GameToPlayResponseMapper gameToPlayResponseMapper;
    private TeamDao teamDao;    // gereksizse sil.
    private StageTeamDao stageTeamDao;
    @Autowired
    public GameToPlayManager(GameToPlayDao gameToPlayDao) {
        this.gameToPlayDao = gameToPlayDao;
    }
    @Autowired
    public void setGameToPlayResponseMapper(GameToPlayResponseMapper gameToPlayResponseMapper) {
        this.gameToPlayResponseMapper = gameToPlayResponseMapper;
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
    public DataResult<GameToPlayResponseDto> createOneGameToPlay(GameToPlayResponseDto newGameToPlayResponseDto) {
        //kontrolleri yapmalısın!!
        Optional<StageTeam> firstStageTeam = this.stageTeamDao.findById(newGameToPlayResponseDto.getFirstTeamId());
        Optional<StageTeam> secondStageTeam = this.stageTeamDao.findById(newGameToPlayResponseDto.getSecondTeamId());
        if(firstStageTeam.isPresent() && secondStageTeam.isPresent()){
            if(gameToPlayToCheckIfDuplicate(firstStageTeam.get().getId(), secondStageTeam.get().getId())){
                return new ErrorDataResult<GameToPlayResponseDto>("aynı takımlar oynatılmak isteniyorsa takımlar yer değiştirmeli!");
            }else{
                GameToPlay newGameToPlay = this.gameToPlayResponseMapper.mapGameToPlayResponseDtoToGameToPlay(newGameToPlayResponseDto);
                this.gameToPlayDao.save(newGameToPlay);
                newGameToPlayResponseDto = this.gameToPlayResponseMapper.mapGameToPlayToGameToPlayResponseDto(newGameToPlay);
                return new SuccessDataResult<GameToPlayResponseDto>(newGameToPlayResponseDto);
            }
        }
        else{
            return new ErrorDataResult<GameToPlayResponseDto>("Takımlar bulunamadı");
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
    public DataResult<GameToPlayResponseDto> updateOneGameToPlay(Long gameToPlayId, GameToPlayResponseDto gameToPlayResponseDto) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            GameToPlay toSave = gameToPlay.get();
            toSave.getStageTeamFirst().setId(gameToPlayResponseDto.getFirstTeamId());
            toSave.getStageTeamSecond().setId(gameToPlayResponseDto.getSecondTeamId());
            toSave.setTarih(gameToPlayResponseDto.getTarih());
            toSave = this.gameToPlayDao.save(toSave);
            GameToPlayResponseDto newGameToPlayResponseDto = gameToPlayResponseMapper.mapGameToPlayToGameToPlayResponseDto(toSave);
            return new SuccessDataResult<GameToPlayResponseDto>(newGameToPlayResponseDto);
        }
        else{
            return new ErrorDataResult<GameToPlayResponseDto>("güncellenmek istenen oynanacak oyun bulunamadı..");
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
