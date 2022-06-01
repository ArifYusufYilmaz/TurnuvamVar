package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;

import java.util.List;

public interface ScorePlayerService {
    DataResult<ScorePlayerResponseDto> createOneScorePlayer(ScorePlayerRequestDto newScorePlayerRequestDto);

    DataResult<ScorePlayerResponseDto> getOneScorePlayerById(Long scorePlayerId);

    DataResult<List<ScorePlayerResponseDto>> getAllScorePlayers();

    DataResult<ScorePlayerResponseDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerRequestDto scorePlayerrRequestDto);

    Result deleteOneScorePlayerById(Long scorePlayerId);
}
