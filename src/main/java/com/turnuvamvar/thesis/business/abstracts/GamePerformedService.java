package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;

import java.util.List;

public interface GamePerformedService {
    DataResult<GamePerformedResponseDto> createOneGamePerformed(GamePerformedResponseDto newGamePerformedResponseDto);

    DataResult<GamePerformed> getOneGamePerformedById(Long gamePerformedId);

    DataResult<GamePerformedResponseDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedResponseDto gamePerformedResponseDto);

    DataResult<List<GamePerformed>> getAllGamesPerformed();

    Result deleteOneGamePerformedById(Long gamePerformedId);
}
