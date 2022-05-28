package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;

import java.util.List;

public interface ScorePlayerService {
    DataResult<ScorePlayerResponseDto> createOneScorePlayer(ScorePlayerResponseDto newScorePlayerResponseDto);

    DataResult<ScorePlayer> getOneScorePlayerById(Long scorePlayerId);

    DataResult<List<ScorePlayer>> getAllScorePlayers();

    DataResult<ScorePlayerResponseDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerResponseDto scorePlayerResponseDto);

    Result deleteOneScorePlayerById(Long scorePlayerId);
}
