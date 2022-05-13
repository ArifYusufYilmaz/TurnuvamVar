package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamestoplay")
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

    @GetMapping
    public DataResult<List<GameToPlay>> getAllGamesToPlay(){
        return this.gameToPlayService.getAllGamesToPlay();
    }

    @GetMapping("/{gameToPlayId}")
    public DataResult<GameToPlay> getOneGameToPlayById(@PathVariable Long gameToPlayId){
        return this.gameToPlayService.getOneGameToPlayById(gameToPlayId);
    }

    @PutMapping("/update/{gameToPlayId}")
    public DataResult<GameToPlayDto> updateOneGameToPlay(@PathVariable Long gameToPlayId, @RequestBody GameToPlayDto gameToPlayDto){
        return this.gameToPlayService.updateOneGameToPlay(gameToPlayId, gameToPlayDto);
    }


    @DeleteMapping("/delete/{gameToPlayId}")
    public Result deleteOneGameToPlay(@PathVariable Long gameToPlayId){
        return this.gameToPlayService.deleteOneGameToPlayById(gameToPlayId);
    }
}
