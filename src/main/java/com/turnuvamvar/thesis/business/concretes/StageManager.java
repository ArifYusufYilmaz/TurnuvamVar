package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.mapper.Request.StageRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.StageResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageManager implements StageService {
    @Autowired
    private StageDao stageDao;
    private StageResponseMapper stageResponseMapper;
    private StageRequestMapper stageRequestMapper;
    @Autowired
    public StageManager(StageDao stageDao) {
        this.stageDao = stageDao;
    }
    @Autowired  //Lazy ?
    public void setStageResponseMapper(StageResponseMapper stageResponseMapper) {
        this.stageResponseMapper = stageResponseMapper;
    }
    @Autowired
    public void setStageRequestMapper(StageRequestMapper stageRequestMapper) {
        this.stageRequestMapper = stageRequestMapper;
    }

    @Override
    public DataResult<StageResponseDto> createOneStage(StageRequestDto newStageRequestDto) {
        // null olma durumunu kontrol et.
        if(checkIfItHasSameStageByName(newStageRequestDto.getStageName())){
            return new ErrorDataResult<StageResponseDto>("Bu aşama ismi zaten mevcut!!");
        }else{
            Stage stage =  this.stageRequestMapper.mapStageRequestDtoToStage(newStageRequestDto);
            stage = this.stageDao.save(stage);
            StageResponseDto stageResponseDto = this.stageResponseMapper.mapStageToStageResponseDto(stage);
            return new SuccessDataResult<StageResponseDto>(stageResponseDto);
        }
    }

    @Override
    public DataResult<StageResponseDto> getOneStageById(Long stageId) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            StageResponseDto stageResponseDto =  this.stageResponseMapper.mapStageToStageResponseDto(stage.get());
             return new SuccessDataResult<StageResponseDto>(stageResponseDto);
        }
        else{
            return new ErrorDataResult<StageResponseDto>("Stage bulunamadı");
        }

    }

    @Override
    public DataResult<StageResponseDto> updateOneStage(Long stageId, StageRequestDto stageRequestDto) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            Stage toSave = stage.get();
            toSave.setStageName(stageRequestDto.getStageName());
            if(checkIfItHasSameStageByName(toSave.getStageName())){
                return new ErrorDataResult<StageResponseDto>("Aynı stage ismine sahip veri zaten mevcut..");
            }else {
                toSave = this.stageDao.save(toSave);
                StageResponseDto newStageResponseDto = stageResponseMapper.mapStageToStageResponseDto(toSave);
                return new SuccessDataResult<StageResponseDto>(newStageResponseDto);
            }
        }
        else{
            return new ErrorDataResult<StageResponseDto>("stage bulunamadı..");
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
    public DataResult<List<StageResponseDto>> getAllStages() {
        List<Stage> stageList = new ArrayList<>();
        Iterable<Stage> stageIterable = this.stageDao.findAll();
        stageIterable.iterator().forEachRemaining(stageList :: add);
        if(stageList.isEmpty()){
            return new ErrorDataResult<StageResponseDto>("stage listesinde hiç stage bulunamadı!");
        }
        else{
            List<StageResponseDto> stageResponseDtoList = this.stageResponseMapper.mapStageListToStageResponseDtoList(stageList);
            return new SuccessDataResult<List<StageResponseDto>>(stageResponseDtoList);
        }
    }
    // if it is an duplicate record as its name returns true
    private boolean checkIfItHasSameStageByName(String stageName){
        // büyük, küçük harf olayından dolayı sorun çıkabilir, Dtodan alırken kontrol etmelisin!
        Stage stage = this.stageDao.findByStageName(stageName).orElse(null);
        return stage != null ? true : false;
    }
}






