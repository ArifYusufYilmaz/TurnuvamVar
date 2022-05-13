package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
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
    @Autowired
    public StageManager(StageDao stageDao) {
        this.stageDao = stageDao;
    }
    @Autowired  //Lazy ?
    public void setStageMapper(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }

    @Override
    public DataResult<StageDto> createOneStage(StageDto newStageDto) {
        // gelen takımların takım listesinde olup olmadığını kontrol et!
        // aynı zamanda aşama tablosuna daha önce yazıldı mı? (aynı aşama adında)
         Stage stage =  this.stageMapper.mapStageDtoToStage(newStageDto);
         StageDto stageDto = this.stageMapper.mapStageToStageDto(this.stageDao.save(stage));
        return new SuccessDataResult<StageDto>(stageDto);

    }

    @Override
    public DataResult<Stage> getOneStageById(Long stageId) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
             return new SuccessDataResult<Stage>(stage.get());
        }
        else{
            return new ErrorDataResult<Stage>("Stage bulunamadı");
        }

    }

    @Override
    public DataResult<StageDto> updateOneStage(Long stageId, StageDto stageDto) {
        Optional<Stage> stage = this.stageDao.findById(stageId);
        if(stage.isPresent()){
            Stage toSave = stage.get();
            toSave.setStageName(stageDto.getStageName());
            toSave = this.stageDao.save(toSave);
            StageDto newStageDto = stageMapper.mapStageToStageDto(toSave);
            return new SuccessDataResult<StageDto>(newStageDto);
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
    public DataResult<List<Stage>> getAllStages() {
        List<Stage> stageList = new ArrayList<>();
        Iterable<Stage> stageIterable = this.stageDao.findAll();
        stageIterable.iterator().forEachRemaining(stageList :: add);
        if(stageList.isEmpty()){
            return new ErrorDataResult<>("stage listesinde hiç stage bulunamadı!");
        }
        else{
            return new SuccessDataResult<List<Stage>>(stageList);
        }
    }
}






