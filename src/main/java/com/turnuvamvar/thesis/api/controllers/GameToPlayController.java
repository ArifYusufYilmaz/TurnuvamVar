package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.GameToPlayService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.GameToPlayRequestDto;
import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gamestoplay")
public class GameToPlayController {
    @Autowired
    private GameToPlayService gameToPlayService;
    @Autowired
    public GameToPlayController(GameToPlayService gameToPlayService) {
        this.gameToPlayService = gameToPlayService;
    }
    @PostMapping("/save")
    public DataResult<GameToPlayResponseDto> createOneGameToPlay(@RequestBody GameToPlayRequestDto newGameToPlayRequestDto){
        return this.gameToPlayService.createOneGameToPlay(newGameToPlayRequestDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<GameToPlayResponseDto>> getAllGamesToPlay(){
        return this.gameToPlayService.getAllGamesToPlay();
    }
    @GetMapping("/get/{gameToPlayId}")
    public DataResult<GameToPlayResponseDto> getOneGameToPlayById(@PathVariable Long gameToPlayId){
        return this.gameToPlayService.getOneGameToPlayById(gameToPlayId);
    }
    @PutMapping("/update/{gameToPlayId}")
    public DataResult<GameToPlayResponseDto> updateOneGameToPlay(@PathVariable Long gameToPlayId, @RequestBody GameToPlayRequestDto gameToPlayRequestDto){
        return this.gameToPlayService.updateOneGameToPlay(gameToPlayId, gameToPlayRequestDto);
    }
    @DeleteMapping("/delete/{gameToPlayId}")
    public Result deleteOneGameToPlay(@PathVariable Long gameToPlayId){
        return this.gameToPlayService.deleteOneGameToPlayById(gameToPlayId);
    }
}
