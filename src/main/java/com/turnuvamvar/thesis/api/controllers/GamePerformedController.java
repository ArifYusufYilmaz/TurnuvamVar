package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.GamePerformedService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.GamePerformedRequestDto;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gamesperformed")
public class GamePerformedController {
    @Autowired
    private GamePerformedService gamePerformedService;
    @Autowired
    public GamePerformedController(GamePerformedService gamePerformedService) {
        this.gamePerformedService = gamePerformedService;
    }
    @PostMapping
    public DataResult<GamePerformedResponseDto> createOneGamePerformed(@RequestBody GamePerformedRequestDto newGamePerformedRequestDto){
        return this.gamePerformedService.createOneGamePerformed(newGamePerformedRequestDto);
    }


    @GetMapping("/{gamePerformedId}")
    public DataResult<GamePerformedResponseDto> getOneGamePerformedById(@PathVariable Long gamePerformedId){
        return this.gamePerformedService.getOneGamePerformedById(gamePerformedId);
    }

    @PutMapping("/update/{gamePerformedId}")
    public DataResult<GamePerformedResponseDto> updateOneGamePerformed(@PathVariable Long gamePerformedId,
                                                                       @RequestBody GamePerformedRequestDto gamePerformedRequestDto){
        return this.gamePerformedService.updateOneGamePerformed(gamePerformedId, gamePerformedRequestDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<GamePerformedResponseDto>> getAllGamesPerformed(){
        return this.gamePerformedService.getAllGamesPerformed();
    }

    @DeleteMapping("/delete/{gamePerformedId}")
    public Result deleteOneGamePerformed(@PathVariable Long gamePerformedId){
        return this.gamePerformedService.deleteOneGamePerformedById(gamePerformedId);
    }
}

