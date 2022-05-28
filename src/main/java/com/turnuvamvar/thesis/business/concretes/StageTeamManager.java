package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.mapper.Request.StageTeamRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.StageTeamResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageTeamManager implements StageTeamService {
    @Autowired
    private StageTeamDao stageTeamDao;
    private StageTeamResponseMapper stageTeamResponseMapper;
    private StageTeamRequestMapper stageTeamRequestMapper;
    private TeamDao teamDao;
    private StageDao stageDao;

    @Autowired
    public StageTeamManager(StageTeamDao stageTeamDao) {
        this.stageTeamDao = stageTeamDao;
    }
    @Autowired
    public void setStageTeamResponseMapper(StageTeamResponseMapper stageTeamResponseMapper) {
        this.stageTeamResponseMapper = stageTeamResponseMapper;
    }
    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    @Autowired
    public void setStageDao(StageDao stageDao) {
        this.stageDao = stageDao;
    }
    @Autowired
    public void setStageTeamRequestMapper(StageTeamRequestMapper stageTeamRequestMapper) {
        this.stageTeamRequestMapper = stageTeamRequestMapper;
    }

    @Override
    public DataResult<StageTeamResponseDto> createOneStageTeam(StageTeamRequestDto newStageTeamRequestDto) {

        Optional<Team> team = this.teamDao.findById(newStageTeamRequestDto.getTeamId());
        Optional<Stage> stage =  this.stageDao.findById(newStageTeamRequestDto.getStageId());
        if(team.isPresent() && stage.isPresent()){ // check if they exist in db
            // to avoid duplicate records
            if(stageTeamToCheckIfDuplicate(team.get().getId(), stage.get().getId())){
                return new ErrorDataResult<StageTeamResponseDto>("Verilen takım ve stage zaten eşlenmiş!!");
            }
            else{
                StageTeam stageTeam = this.stageTeamRequestMapper.mapStageTeamRequestDtoToStageTeam(newStageTeamRequestDto);
                stageTeam = this.stageTeamDao.save(stageTeam);
                StageTeamResponseDto stageTeamResponseDto = this.stageTeamResponseMapper.mapStageTeamToStageTeamResponseDto(stageTeam);
                return new SuccessDataResult<StageTeamResponseDto>(stageTeamResponseDto);
            }
        }else{
            return new ErrorDataResult<StageTeamResponseDto>("Verilen takım ya da stage mevcut değil!!");
        }
    }

    @Override
    public DataResult<List<StageTeamResponseDto>> getAllStagesTeams() {
        List<StageTeam> stageTeamList = new ArrayList<>();
        Iterable<StageTeam> stageTeamIterable = this.stageTeamDao.findAll();
        stageTeamIterable.iterator().forEachRemaining(stageTeamList :: add);
        if(stageTeamList.isEmpty()){
            return new ErrorDataResult<List<StageTeamResponseDto>>("aşama_takım   listesinde hiç aşama_takım bulunamadı!");
        }
        else{
            List<StageTeamResponseDto> stageTeamResponseDtoList = this.stageTeamResponseMapper.mapStageTeamListToStageTeamResponseDtoList(stageTeamList);
            return new SuccessDataResult<List<StageTeamResponseDto>>(stageTeamResponseDtoList);
        }
    }

    @Override
    public DataResult<StageTeamResponseDto> getOneStageTeamById(Long stageTeamId) {
        Optional<StageTeam> stageTeam = this.stageTeamDao.findById(stageTeamId);
        if(stageTeam.isPresent()){
            StageTeamResponseDto stageTeamResponseDto =  this.stageTeamResponseMapper.mapStageTeamToStageTeamResponseDto(stageTeam.get());
            return new SuccessDataResult<StageTeamResponseDto>(stageTeamResponseDto);
        }
        else{
            return new ErrorDataResult<StageTeamResponseDto>("aşama_takım bulunamadı");
        }
    }

    @Override
    public DataResult<StageTeamResponseDto> updateOneStageTeam(Long stageTeamId, StageTeamRequestDto stageTeamRequestDto) {
        Optional<StageTeam> stageTeam = this.stageTeamDao.findById(stageTeamId);
        if(stageTeam.isPresent()){
            StageTeam toSave = stageTeam.get();
            toSave.getStage().setId(stageTeamRequestDto.getStageId());
            toSave.getTeam().setId(stageTeamRequestDto.getTeamId());
            // to avoid duplicate records
            //StageTeam stageTeamToCheckİfDuplicate = this.stageTeamDao.findByTeamIdAndStageId(toSave.getTeam().getId(),toSave.getStage().getId()).orElse(null);
            if(stageTeamToCheckIfDuplicate(toSave.getTeam().getId(),toSave.getStage().getId())){
                return new ErrorDataResult<StageTeamResponseDto>("Verilen takım ve stage zaten eşlenmiş!!");
            }else{
                toSave = this.stageTeamDao.save(toSave);
                StageTeamResponseDto newStageTeamResponseDto = stageTeamResponseMapper.mapStageTeamToStageTeamResponseDto(toSave);
                return new SuccessDataResult<StageTeamResponseDto>(newStageTeamResponseDto);
            }
        }
        else{
            return new ErrorDataResult<StageTeamResponseDto>("güncellenmek istenen aşama_takım bulunamadı..");
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
