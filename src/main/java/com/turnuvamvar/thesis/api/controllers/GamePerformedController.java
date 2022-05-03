package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.GamePerformedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameperformed")
public class GamePerformedController {
    @Autowired
    private GamePerformedService gamePerformedService;
    @Autowired
    public GamePerformedController(GamePerformedService gamePerformedService) {
        this.gamePerformedService = gamePerformedService;
    }
    @PostMapping
    public DataResult<GamePerformedDto> createOneGamePerformed(@RequestBody GamePerformedDto newGamePerformedDto){
        return this.gamePerformedService.createOneGamePerformed(newGamePerformedDto);
    }
}

