package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.GamePerformedDto;

public interface GamePerformedService {
    DataResult<GamePerformedDto> createOneGamePerformed(GamePerformedDto newGamePerformedDto);
}
