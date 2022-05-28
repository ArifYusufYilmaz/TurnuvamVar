package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageResponseDto;

import java.util.List;

public interface StageService {
    DataResult<StageResponseDto> createOneStage(StageRequestDto newStageRequestDto);

    DataResult<StageResponseDto> getOneStageById(Long stageId);

    DataResult<StageResponseDto> updateOneStage(Long stageId, StageRequestDto stageRequestDto);

    Result deleteOneStageById(Long stageId);

    DataResult<List<StageResponseDto>> getAllStages();
}
