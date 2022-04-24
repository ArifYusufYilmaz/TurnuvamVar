package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playertoadd")
public class PlayerToAddController {
    private PlayerToAddService playerToAddService;
    @Autowired
    public PlayerToAddController(PlayerToAddService playerToAddService) {
        this.playerToAddService = playerToAddService;
    }
    @PostMapping("/save/{teamCaptainId}")
    public DataResult<PlayerToAddDto> createOnePlayerToAdd(@PathVariable Long teamCaptainId, @RequestBody PlayerToAddDto newPlayerToAddDto){
        return this.playerToAddService.createOnePlayerToAdd(teamCaptainId,newPlayerToAddDto);
    }
}
