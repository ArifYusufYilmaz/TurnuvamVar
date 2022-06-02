package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.PlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.PlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/save")
    public DataResult<PlayerResponseDto> createOnePlayer(Long playerToAddDtoId){
        return this.playerService.createOnePlayer(playerToAddDtoId);
    }
    @GetMapping("/get/{playerId}")
    public DataResult<PlayerResponseDto> getOnePlayerById(@PathVariable Long playerId){
        return this.playerService.getOnePlayerById(playerId);
    }
    @PutMapping("/update/{playerId}")
    public DataResult<PlayerResponseDto> updateOnePlayer(@PathVariable Long playerId, @RequestBody PlayerRequestDto playerRequestDto){
        return this.playerService.updateOnePlayer(playerId, playerRequestDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<PlayerResponseDto>> getAllPlayers(@RequestParam(required = false) Long teamId){
        return this.playerService.getAllPlayers(teamId);
    }
    @DeleteMapping("/delete/{playerId}")
    public Result deleteOnePlayer(@PathVariable Long playerId){
        return this.playerService.deleteOnePlayerById(playerId);
    }
}
