package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;

import java.util.List;

public interface StageService {
    DataResult<StageDto> createOneStage(StageDto newStageDto);

    DataResult<StageRequestDto> getOneStageById(Long stageId);

    DataResult<StageDto> updateOneStage(Long stageId, StageDto stageDto);

    Result deleteOneStageById(Long stageId);

    DataResult<List<StageRequestDto>> getAllStages();
}
