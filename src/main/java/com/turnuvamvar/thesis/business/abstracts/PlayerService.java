package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.PlayerDto;
import com.turnuvamvar.thesis.entities.concretes.Player;

public interface PlayerService {
    DataResult<Player> createOnePlayer(Long playerToAddDtoId); //admin id, playerToAdd ya da dto id gelmeli.
}
