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
    public DataResult<PlayerToAddResponseDto> createOnePlayerToAdd(@PathVariable Long teamId, @RequestBody PlayerToAddResponseDto newPlayerToAddResponseDto){
        return this.playerToAddService.createOnePlayerToAdd(teamId, newPlayerToAddResponseDto);
    }
    @GetMapping("/get/{playerToAddId}")
    public DataResult<PlayerToAddRequestDto> getOnePlayerToAddById(@PathVariable Long playerToAddId){
        return this.playerToAddService.getOnePlayerToAddById(playerToAddId);
    }
    @GetMapping("/get/list")
    public DataResult<List<PlayerToAddRequestDto>> getAllPlayersToAdd(){
        return this.playerToAddService.getAllPlayersToAdd();
    }
    @PutMapping("/update/{playerToAddId}")
    public DataResult<PlayerToAddResponseDto> updateOnePlayerToAdd(@PathVariable Long playerToAddId,
                                                                   @RequestBody PlayerToAddResponseDto playerToAddResponseDto){
        return this.playerToAddService.updateOnePlayerToAdd(playerToAddId, playerToAddResponseDto);
    }
    @DeleteMapping("/delete/{playerToAddId}")
    public Result deleteOnePlayerToAddById(@PathVariable Long playerToAddId)
    {
        return this.playerToAddService.deleteOnePlayerToAddById(playerToAddId);
    }
}
