package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;

import java.util.List;

public interface StageTeamService {
    DataResult<StageTeamResponseDto> createOneStageTeam(StageTeamRequestDto newStageTeamRequestDto);

    DataResult<List<StageTeamResponseDto>> getAllStagesTeams(Long stageId);

    DataResult<StageTeamResponseDto> getOneStageTeamById(Long stageTeamId);

    DataResult<StageTeamResponseDto> updateOneStageTeam(Long stageTeamId, StageTeamRequestDto stageTeamRequestDto);

    Result deleteOneStageTeamById(Long stageTeamId);
}
