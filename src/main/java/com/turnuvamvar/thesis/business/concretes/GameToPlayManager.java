package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.GameToPlayDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.Request.GameToPlayRequestDto;
import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.mapper.Request.GameToPlayRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.GameToPlayResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PreRemove;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameToPlayManager implements GameToPlayService {
    @Autowired
    private GameToPlayDao gameToPlayDao;
    private GameToPlayResponseMapper gameToPlayResponseMapper;
    private GameToPlayRequestMapper gameToPlayRequestMapper;
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
    public void setGameToPlayRequestMapper(GameToPlayRequestMapper gameToPlayRequestMapper) {
        this.gameToPlayRequestMapper = gameToPlayRequestMapper;
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
    public DataResult<GameToPlayResponseDto> createOneGameToPlay(GameToPlayRequestDto newGameToPlayRequestDto) {
        //kontrolleri yapmalısın!!
        Optional<StageTeam> firstStageTeam = this.stageTeamDao.findById(newGameToPlayRequestDto.getFirstStageTeamId());
        Optional<StageTeam> secondStageTeam = this.stageTeamDao.findById(newGameToPlayRequestDto.getSecondStageTeamId());
        if(firstStageTeam.isPresent() && secondStageTeam.isPresent()){
            if(gameToPlayToCheckIfDuplicate(firstStageTeam.get().getId(), secondStageTeam.get().getId())){
                return new ErrorDataResult<GameToPlayResponseDto>("aynı takımlar oynatılmak isteniyorsa takımlar yer değiştirmeli!");
            }else if(toCheckIfAlreadyHasFirstStageTeamOnSameColumn(firstStageTeam.get().getId()) ||
            toCheckIfAlreadyHasSecondStageTeamOnSameColumn(secondStageTeam.get().getId())){
                return new ErrorDataResult<GameToPlayResponseDto>("Aynı aşamadaki takım sadece 1 kez oyun oynayabilir!");
            }
            else{
                GameToPlay newGameToPlay = this.gameToPlayRequestMapper.mapGameToPlayRequestDtoToGameToPlay(newGameToPlayRequestDto);
                newGameToPlay.setStageTeamFirst(firstStageTeam.get());
                newGameToPlay.setStageTeamSecond(secondStageTeam.get());
                newGameToPlay = this.gameToPlayDao.save(newGameToPlay);
                GameToPlayResponseDto newGameToPlayResponseDto = this.gameToPlayResponseMapper.mapGameToPlayToGameToPlayResponseDto(newGameToPlay);
                return new SuccessDataResult<GameToPlayResponseDto>(newGameToPlayResponseDto);
            }
        }
        else{
            return new ErrorDataResult<GameToPlayResponseDto>("Takımlar bulunamadı");
        }

    }

    @Override
    public DataResult<List<GameToPlayResponseDto>> getAllGamesToPlay() {
        List<GameToPlay> gameToPlayList = new ArrayList<>();
        Iterable<GameToPlay> gameToPlayIterable = this.gameToPlayDao.findAll();
        gameToPlayIterable.iterator().forEachRemaining(gameToPlayList :: add);
        if(gameToPlayList.isEmpty()){
            return new ErrorDataResult<List<GameToPlayResponseDto>>("oynanacak oyun  listesinde hiç stage bulunamadı!");
        }
        else{
            List<GameToPlayResponseDto> gameToPlayResponseDtoList = this.gameToPlayResponseMapper.mapGameToPlayListToGameToPlayResponseDtoList(gameToPlayList);
            return new SuccessDataResult<List<GameToPlayResponseDto>>(gameToPlayResponseDtoList);
        }
    }

    @Override
    public DataResult<GameToPlayResponseDto> getOneGameToPlayById(Long gameToPlayId) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            GameToPlayResponseDto gameToPlayResponseDto = this.gameToPlayResponseMapper.mapGameToPlayToGameToPlayResponseDto(gameToPlay.get());
            return new SuccessDataResult<GameToPlayResponseDto>(gameToPlayResponseDto);
        }
        else{
            return new ErrorDataResult<GameToPlayResponseDto>("oynanacak maç bulunamadı");
        }
    }

    @Override
    public DataResult<GameToPlayResponseDto> updateOneGameToPlay(Long gameToPlayId, GameToPlayRequestDto gameToPlayRequestDto) {
        Optional<GameToPlay> gameToPlay = this.gameToPlayDao.findById(gameToPlayId);
        if(gameToPlay.isPresent()){
            GameToPlay toSave = gameToPlay.get();
            toSave.getStageTeamFirst().setId(gameToPlayRequestDto.getFirstStageTeamId());
            toSave.getStageTeamSecond().setId(gameToPlayRequestDto.getSecondStageTeamId());
            toSave.setTarih(gameToPlayRequestDto.getTarih());
            toSave = this.gameToPlayDao.save(toSave);
            GameToPlayResponseDto newGameToPlayResponseDto = this.gameToPlayResponseMapper.mapGameToPlayToGameToPlayResponseDto(toSave);
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
    private boolean toCheckIfAlreadyHasFirstStageTeamOnSameColumn(Long firstStageTeamId){
        GameToPlay gameToPlay = this.gameToPlayDao.findByStageTeamFirstId(firstStageTeamId);
        return gameToPlay != null ? true : false;
    }
    private boolean toCheckIfAlreadyHasSecondStageTeamOnSameColumn(Long secondStageTeamId){
        GameToPlay gameToPlay = this.gameToPlayDao.findByStageTeamSecondId(secondStageTeamId);
        return gameToPlay != null ? true : false;
    }

}
