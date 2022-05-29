package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playertoadd")
public class PlayerToAddController {
    private PlayerToAddService playerToAddService;
    @Autowired
    public PlayerToAddController(PlayerToAddService playerToAddService) {
        this.playerToAddService = playerToAddService;
    }
    @PostMapping("/save/{teamId}")
    public DataResult<PlayerToAddResponseDto> createOnePlayerToAdd(@PathVariable Long teamId, @RequestBody PlayerToAddRequestDto newPlayerToAddRequestDto){
        return this.playerToAddService.createOnePlayerToAdd(teamId, newPlayerToAddRequestDto);
    }
    @GetMapping("/get/{playerToAddId}")
    public DataResult<PlayerToAddResponseDto> getOnePlayerToAddById(@PathVariable Long playerToAddId){
        return this.playerToAddService.getOnePlayerToAddById(playerToAddId);
    }
    @GetMapping("/get/list")
    public DataResult<List<PlayerToAddResponseDto>> getAllPlayersToAdd(@RequestParam(required = false) Long teamId){
        return this.playerToAddService.getAllPlayersToAdd(teamId);
    }
    @PutMapping("/update/{playerToAddId}")
    public DataResult<PlayerToAddResponseDto> updateOnePlayerToAdd(@PathVariable Long playerToAddId,
                                                                   @RequestBody PlayerToAddRequestDto playerToAddRequestDto){
        return this.playerToAddService.updateOnePlayerToAdd(playerToAddId, playerToAddRequestDto);
    }
    @DeleteMapping("/delete/{playerToAddId}")
    public Result deleteOnePlayerToAddById(@PathVariable Long playerToAddId)
    {
        return this.playerToAddService.deleteOnePlayerToAddById(playerToAddId);
    }
}
