package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;

import java.util.List;

public interface GamePerformedService {
    DataResult<GamePerformedDto> createOneGamePerformed(GamePerformedDto newGamePerformedDto);

    DataResult<GamePerformed> getOneGamePerformedById(Long gamePerformedId);

    DataResult<GamePerformedDto> updateOneGamePerformed(Long gamePerformedId, GamePerformedDto gamePerformedDto);

    DataResult<List<GamePerformed>> getAllGamesPerformed();

    Result deleteOneGamePerformedById(Long gamePerformedId);
}
