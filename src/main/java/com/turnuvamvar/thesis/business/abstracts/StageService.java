package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;

public interface StageService {
    DataResult<StageDto> createOneStage(StageDto newStageDto);
}
