package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;

import java.util.List;

public interface PlayerService {
    DataResult<Player> createOnePlayer(Long playerToAddDtoId); //admin id, playerToAdd ya da dto id gelmeli.

    DataResult<Player> getOnePlayerById(Long playerId);

    DataResult<PlayerResponseDto> updateOnePlayer(Long playerId, PlayerResponseDto playerResponseDto);

    DataResult<List<Player>> getAllPlayers();

    Result deleteOnePlayerById(Long playerId);
}
