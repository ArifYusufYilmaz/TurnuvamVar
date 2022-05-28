package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageResponseDto;

import java.util.List;

public interface StageService {
    DataResult<StageResponseDto> createOneStage(StageResponseDto newStageResponseDto);

    DataResult<StageRequestDto> getOneStageById(Long stageId);

    DataResult<StageResponseDto> updateOneStage(Long stageId, StageResponseDto stageResponseDto);

    Result deleteOneStageById(Long stageId);

    DataResult<List<StageRequestDto>> getAllStages();
}
