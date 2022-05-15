package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.mapper.StageTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageTeamManager implements StageTeamService {
    @Autowired
    private StageTeamDao stageTeamDao;
    private StageTeamMapper stageTeamMapper;
    private TeamDao teamDao;
    private StageDao stageDao;
    @Autowired
    public StageTeamManager(StageTeamDao stageTeamDao) {
        this.stageTeamDao = stageTeamDao;
    }
    @Autowired
    public void setStageTeamMapper(StageTeamMapper stageTeamMapper) {
        this.stageTeamMapper = stageTeamMapper;
    }
    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    @Autowired
    public void setStageDao(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public DataResult<StageTeamDto> createOneStageTeam(StageTeamDto newStageTeamDto) {

        Optional<Team> team = this.teamDao.findById(newStageTeamDto.getTeamId());
        Optional<Stage> stage =  this.stageDao.findById(newStageTeamDto.getStageId());
        if(team.isPresent() && stage.isPresent()){ // check if they exist in db
            // to avoid duplicate records
            if(stageTeamToCheckIfDuplicate(team.get().getId(), stage.get().getId())){
                return new ErrorDataResult<StageTeamDto>("Verilen takım ve stage zaten eşlenmiş!!");
            }
            else{
                StageTeam stageTeam = this.stageTeamMapper.mapStageTeamDtoToStage(newStageTeamDto);
                StageTeamDto stageTeamDto = this.stageTeamMapper.mapStageTeamToStageTeamDto(this.stageTeamDao.save(stageTeam));
                return new SuccessDataResult<StageTeamDto>(stageTeamDto);
            }

        }else{
            return new ErrorDataResult<StageTeamDto>("Verilen takım ya da stage mevcut değil!!");
        }
    }

    @Override
    public DataResult<List<StageTeam>> getAllStagesTeams() {
        List<StageTeam> stageTeamList = new ArrayList<>();
        Iterable<StageTeam> stageTeamIterable = this.stageTeamDao.findAll();
        stageTeamIterable.iterator().forEachRemaining(stageTeamList :: add);
        if(stageTeamList.isEmpty()){
            return new ErrorDataResult<List<StageTeam>>("aşama_takım   listesinde hiç aşama_takım bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<StageTeam>>(stageTeamList);
        }
    }

    @Override
    public DataResult<StageTeam> getOneStageTeamById(Long stageTeamId) {
        Optional<StageTeam> stageTeam = this.stageTeamDao.findById(stageTeamId);
        if(stageTeam.isPresent()){
            return new SuccessDataResult<StageTeam>(stageTeam.get());
        }
        else{
            return new ErrorDataResult<StageTeam>("aşama_takım bulunamadı");
        }
    }

    @Override
    public DataResult<StageTeamDto> updateOneStageTeam(Long stageTeamId, StageTeamDto stageTeamDto) {
        Optional<StageTeam> stageTeam = this.stageTeamDao.findById(stageTeamId);
        if(stageTeam.isPresent()){
            StageTeam toSave = stageTeam.get();
            toSave.getStage().setId(stageTeamDto.getStageId());
            toSave.getTeam().setId(stageTeamDto.getTeamId());
            // to avoid duplicate records
            //StageTeam stageTeamToCheckİfDuplicate = this.stageTeamDao.findByTeamIdAndStageId(toSave.getTeam().getId(),toSave.getStage().getId()).orElse(null);
            if(stageTeamToCheckIfDuplicate(toSave.getTeam().getId(),toSave.getStage().getId())){
                return new ErrorDataResult<StageTeamDto>("Verilen takım ve stage zaten eşlenmiş!!");
            }else{
                toSave = this.stageTeamDao.save(toSave);
                StageTeamDto newStageTeamDto = stageTeamMapper.mapStageTeamToStageTeamDto(toSave);
                return new SuccessDataResult<StageTeamDto>(newStageTeamDto);
            }
        }
        else{
            return new ErrorDataResult<StageTeamDto>("güncellenmek istenen aşama_takım bulunamadı..");
        }
    }

    @Override
    public Result deleteOneStageTeamById(Long stageTeamId) {
        Optional<StageTeam> stageTeam = this.stageTeamDao.findById(stageTeamId);
        if(stageTeam.isPresent()){
            this.stageTeamDao.deleteById(stageTeam.get().getId());
            return new SuccessResult("aşama_takım silindi..");
        }
        else{
            return new ErrorResult("aşama_takım bulunamadığı için silinemedi!");
        }
    }

    // if it is an duplicate record returns true
    private boolean stageTeamToCheckIfDuplicate(Long teamId, Long stageId){
        StageTeam stageTeam = this.stageTeamDao.findByTeamIdAndStageId(teamId, stageId).orElse(null);
        return stageTeam != null ? true : false;
    }
}
