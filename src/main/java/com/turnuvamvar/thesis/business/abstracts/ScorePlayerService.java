package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;

import java.util.List;

public interface ScorePlayerService {
    DataResult<ScorePlayerDto> createOneScorePlayer(ScorePlayerDto newScorePlayerDto);

    DataResult<ScorePlayer> getOneScorePlayerById(Long scorePlayerId);

    DataResult<List<ScorePlayer>> getAllScorePlayers();

    DataResult<ScorePlayerDto> updateOneScorePlayer(Long scorePlayerId, ScorePlayerDto scorePlayerDto);

    Result deleteOneScorePlayerById(Long scorePlayerId);
}
