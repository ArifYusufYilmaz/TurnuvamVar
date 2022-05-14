package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
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
    public DataResult<PlayerToAddDto> createOnePlayerToAdd(@PathVariable Long teamId, @RequestBody PlayerToAddDto newPlayerToAddDto){
        return this.playerToAddService.createOnePlayerToAdd(teamId,newPlayerToAddDto);
    }
    @GetMapping("/get/{playerToAddId}")
    public DataResult<PlayerToAdd> getOnePlayerToAddById(@PathVariable Long playerToAddId){
        return this.playerToAddService.getOnePlayerToAddById(playerToAddId);
    }
    @GetMapping("/get/list")
    public DataResult<List<PlayerToAdd>> getAllPlayersToAdd(){
        return this.playerToAddService.getAllPlayersToAdd();
    }
    @PutMapping("/update/{playerToAddId}")
    public DataResult<PlayerToAddDto> updateOnePlayerToAdd(@PathVariable Long playerToAddId,
                                                           @RequestBody PlayerToAddDto playerToAddDto){
        return this.playerToAddService.updateOnePlayerToAdd(playerToAddId, playerToAddDto);
    }
    @DeleteMapping("/delete/{playerToAddId}")
    public Result deleteOnePlayerToAddById(@PathVariable Long playerToAddId)
    {
        return this.playerToAddService.deleteOnePlayerToAddById(playerToAddId);
    }
}
