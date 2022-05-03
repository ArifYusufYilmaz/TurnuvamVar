package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;

public interface GameToPlayService {
    DataResult<GameToPlayDto> createOneGameToPlay(GameToPlayDto newGameToPlayDto);
}
