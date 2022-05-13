package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;

import java.util.List;

public interface GameToPlayService {
    DataResult<GameToPlayDto> createOneGameToPlay(GameToPlayDto newGameToPlayDto);

    DataResult<List<GameToPlay>> getAllGamesToPlay();

    DataResult<GameToPlay> getOneGameToPlayById(Long gameToPlayId);

    DataResult<GameToPlayDto> updateOneGameToPlay(Long gameToPlayId, GameToPlayDto gameToPlayDto);

    Result deleteOneGameToPlayById(Long gameToPlayId);
}
