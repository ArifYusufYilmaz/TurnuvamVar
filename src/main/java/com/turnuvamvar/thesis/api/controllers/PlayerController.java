package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.PlayerDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/save")           // burada bir sıkıntı var!!! path variable vs.
    public DataResult<Player> createOnePlayer(Long playerToAddDtoId){
        return this.playerService.createOnePlayer(playerToAddDtoId);
    }


    @GetMapping("/{playerId}")
    public DataResult<Player> getOnePlayerById(@PathVariable Long playerId){
        return this.playerService.getOnePlayerById(playerId);
    }

    @PutMapping("/update/{playerId}")
    public DataResult<PlayerDto> updateOnePlayer(@PathVariable Long playerId, @RequestBody PlayerDto playerDto){
        return this.playerService.updateOnePlayer(playerId, playerDto);
    }
    @GetMapping
    public DataResult<List<Player>> getAllPlayers(){
        return this.playerService.getAllPlayers();
    }

    @DeleteMapping("/delete/{playerId}")
    public Result deleteOnePlayer(@PathVariable Long playerId){
        return this.playerService.deleteOnePlayerById(playerId);
    }

}
