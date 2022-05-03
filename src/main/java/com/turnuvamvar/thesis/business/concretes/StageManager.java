package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageDao;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.mapper.StageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
}






