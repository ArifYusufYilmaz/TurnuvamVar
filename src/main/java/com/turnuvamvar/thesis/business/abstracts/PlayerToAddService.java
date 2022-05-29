package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;

import java.util.List;

public interface PlayerToAddService {
    DataResult<PlayerToAddResponseDto> createOnePlayerToAdd(Long teamId, PlayerToAddRequestDto newPlayerToAddRequestDto);

    DataResult<PlayerToAddResponseDto> updateOnePlayerToAdd(Long playerToAddId, PlayerToAddRequestDto playerToAddRequestDto);

    DataResult<PlayerToAddResponseDto> getOnePlayerToAddById(Long playerToAddId);

    DataResult<List<PlayerToAddResponseDto>> getAllPlayersToAdd(Long teamId);

    Result deleteOnePlayerToAddById(Long playerToAddId);
}
