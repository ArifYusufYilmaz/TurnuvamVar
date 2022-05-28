package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;

import java.util.List;

public interface GameToPlayService {
    DataResult<GameToPlayResponseDto> createOneGameToPlay(GameToPlayResponseDto newGameToPlayResponseDto);

    DataResult<List<GameToPlay>> getAllGamesToPlay();

    DataResult<GameToPlay> getOneGameToPlayById(Long gameToPlayId);

    DataResult<GameToPlayResponseDto> updateOneGameToPlay(Long gameToPlayId, GameToPlayResponseDto gameToPlayResponseDto);

    Result deleteOneGameToPlayById(Long gameToPlayId);
}
