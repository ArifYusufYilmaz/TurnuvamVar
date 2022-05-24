package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;

import java.util.List;

public interface PlayerToAddService {
    DataResult<PlayerToAddDto> createOnePlayerToAdd(Long teamId,PlayerToAddDto newPlayerToAddDto);

    

    DataResult<PlayerToAddDto> updateOnePlayerToAdd(Long playerToAddId, PlayerToAddDto playerToAddDto);

    DataResult<PlayerToAddRequestDto> getOnePlayerToAddById(Long playerToAddId);

    DataResult<List<PlayerToAddRequestDto>> getAllPlayersToAdd();

    Result deleteOnePlayerToAddById(Long playerToAddId);
}
