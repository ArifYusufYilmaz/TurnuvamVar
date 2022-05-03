package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;

public interface ScorePlayerService {
    DataResult<ScorePlayerDto> createOneScorePlayer(ScorePlayerDto newScorePlayerDto);
}
