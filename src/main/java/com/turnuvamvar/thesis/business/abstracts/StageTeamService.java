package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.StageTeamDto;

public interface StageTeamService {
    DataResult<StageTeamDto> createOneStageTeam(StageTeamDto newStageTeamDto);
}