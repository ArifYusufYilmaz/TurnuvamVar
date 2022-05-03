package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gametoplay")
public class GameToPlayController {
    @Autowired
    private GameToPlayService gameToPlayService;
    @Autowired
    public GameToPlayController(GameToPlayService gameToPlayService) {
        this.gameToPlayService = gameToPlayService;
    }
    @PostMapping("/save")
    public DataResult<GameToPlayDto> createOneGameToPlay(@RequestBody GameToPlayDto newGameToPlayDto){
        return this.gameToPlayService.createOneGameToPlay(newGameToPlayDto);
    }
}
