package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.mapper.Request.StageRequestMapper;
import com.turnuvamvar.thesis.mapper.StageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageManager implements StageService {
    @Autowired
    private StageDao stageDao;
    private StageMapper stageMapper;
    private StageRequestMapper stageRequestMapper;
    @Autowired
    public StageManager(StageDao stageDao) {
        this.stageDao = stageDao;
    }
    @Autowired  //Lazy ?
    public void setStageMapper(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }
    @Autowired
    public void setStageRequestMapper(StageRequestMapper stageRequestMapper) {
        this.stageRequestMapper = stageRequestMapper;
    }

    @Override
    public DataResult<StageDto> createOneStage(StageDto newStageDto) {
        if(checkIfItHasSameStageByName(newStageDto.getStageName())){
            return new ErrorDataResult<StageDto>("Bu aşama ismi zaten mevcut!!");
        }else{
            Stage stage =  this.stageMapper.mapStageDtoToStage(newStageDto);
            StageDto stageDto = this.stageMapper.mapStageToStageDto(this.stageDao.save(stage));
            return new SuccessDataResult<StageDto>(stageDto);
        }
    }

    @Override
    public DataResult<StageRequestDto> getOneStageById(Long stageId) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
           StageRequestDto stageRequestDto =  stageRequestMapper.mapStageToStageRequestDto(stage.get());
             return new SuccessDataResult<StageRequestDto>(stageRequestDto);
        }
        else{
            return new ErrorDataResult<StageRequestDto>("Stage bulunamadı");
        }

    }

    @Override
    public DataResult<StageDto> updateOneStage(Long stageId, StageDto stageDto) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            Stage toSave = stage.get();
            toSave.setStageName(stageDto.getStageName());
            if(checkIfItHasSameStageByName(toSave.getStageName())){
                return new ErrorDataResult<StageDto>("Aynı stage ismine sahip veri zaten mevcut..");
            }else {
                toSave = this.stageDao.save(toSave);
                StageDto newStageDto = stageMapper.mapStageToStageDto(toSave);
                return new SuccessDataResult<StageDto>(newStageDto);
            }
        }
        else{
            return new ErrorDataResult<StageDto>("stage bulunamadı..");
        }

    }

    @Override
    public Result deleteOneStageById(Long stageId) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            this.stageDao.deleteById(stage.get().getId());
            return new SuccessResult("stage silindi..");
        }
        else{
            return new ErrorResult("Stage bulunamadığı için silinemedi!");
        }
    }

    @Override
    public DataResult<List<StageRequestDto>> getAllStages() {
        List<Stage> stageList = new ArrayList<>();
        Iterable<Stage> stageIterable = this.stageDao.findAll();
        stageIterable.iterator().forEachRemaining(stageList :: add);
        if(stageList.isEmpty()){
            return new ErrorDataResult<StageRequestDto>("stage listesinde hiç stage bulunamadı!");
        }
        else{
            List<StageRequestDto> stageRequestDtoList = stageRequestMapper.mapStageListToStageRequestDtoList(stageList);
            return new SuccessDataResult<List<StageRequestDto>>(stageRequestDtoList);
        }
    }
    // if it is an duplicate record as its name returns true
    private boolean checkIfItHasSameStageByName(String stageName){
        // büyük, küçük harf olayından dolayı sorun çıkabilir, Dtodan alırken kontrol etmelisin!
        Stage stage = this.stageDao.findByStageName(stageName).orElse(null);
        return stage != null ? true : false;
    }
}






