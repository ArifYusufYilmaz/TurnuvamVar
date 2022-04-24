package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;

public interface PlayerToAddService {
    DataResult<PlayerToAddDto> createOnePlayerToAdd(Long teamCaptainId,PlayerToAddDto newPlayerToAddDto);
}
