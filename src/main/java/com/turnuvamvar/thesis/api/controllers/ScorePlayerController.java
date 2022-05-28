package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scoresplayers")
public class ScorePlayerController {

    @Autowired
    private ScorePlayerService scorePlayerService;

    public ScorePlayerController(ScorePlayerService scorePlayerService) {
        this.scorePlayerService = scorePlayerService;
    }

    @PostMapping("/save")
    public DataResult<ScorePlayerResponseDto> createOneScorePlayer(@RequestBody ScorePlayerResponseDto newScorePlayerResponseDto){
        return this.scorePlayerService.createOneScorePlayer(newScorePlayerResponseDto);
    }


    @GetMapping("/get/{scorePlayerId}")
    public DataResult<ScorePlayer> getOneScorePlayerById(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.getOneScorePlayerById(scorePlayerId);
    }

    @PutMapping("/update/{scorePlayerId}")
    public DataResult<ScorePlayerResponseDto> updateOneScorePlayer(@PathVariable Long scorePlayerId,
                                                                   @RequestBody ScorePlayerResponseDto scorePlayerResponseDto){
        return this.scorePlayerService.updateOneScorePlayer(scorePlayerId, scorePlayerResponseDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<ScorePlayer>> getAllScorePlayers(){
        return this.scorePlayerService.getAllScorePlayers();
    }

    @DeleteMapping("/delete/{scorePlayerId}")
    public Result deleteOneScorePlayer(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.deleteOneScorePlayerById(scorePlayerId);
    }

}
