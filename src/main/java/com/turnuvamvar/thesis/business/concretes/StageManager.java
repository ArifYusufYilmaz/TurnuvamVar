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
    public DataResult<StageResponseDto> createOneStage(StageResponseDto newStageResponseDto) {
        if(checkIfItHasSameStageByName(newStageResponseDto.getStageName())){
            return new ErrorDataResult<StageResponseDto>("Bu aşama ismi zaten mevcut!!");
        }else{
            Stage stage =  this.stageResponseMapper.mapStageResponseDtoToStage(newStageResponseDto);
            StageResponseDto stageResponseDto = this.stageResponseMapper.mapStageToStageResponseDto(this.stageDao.save(stage));
            return new SuccessDataResult<StageResponseDto>(stageResponseDto);
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
    public DataResult<StageResponseDto> updateOneStage(Long stageId, StageResponseDto stageResponseDto) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            Stage toSave = stage.get();
            toSave.setStageName(stageResponseDto.getStageName());
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






