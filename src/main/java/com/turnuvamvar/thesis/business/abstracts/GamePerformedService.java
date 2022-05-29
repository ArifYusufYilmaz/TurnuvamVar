package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.GamePerformedRequestDto;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;

import java.util.List;

public interface GamePerformedService {
    DataResult<GamePerformedResponseDto> createOneGamePerformed(GamePerformedRequestDto newGamePerformedResponseDto);

    DataResult<GamePerformedResponseDto> getOneGamePerformedById(Long gamePerformedId);

    DataResult<GamePerformedResponseDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedRequestDto gamePerformedRequestDto);

    DataResult<List<GamePerformedResponseDto>> getAllGamesPerformed();

    Result deleteOneGamePerformedById(Long gamePerformedId);
}
