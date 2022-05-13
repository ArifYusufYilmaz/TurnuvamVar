package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;

import java.util.List;

public interface StageTeamService {
    DataResult<StageTeamDto> createOneStageTeam(StageTeamDto newStageTeamDto);

    DataResult<List<StageTeam>> getAllStagesTeams();

    DataResult<StageTeam> getOneStageTeamById(Long stageTeamId);

    DataResult<StageTeamDto> updateOneStageTeam(Long stageTeamId, StageTeamDto stageTeamDto);

    Result deleteOneStageTeamById(Long stageTeamId);
}
