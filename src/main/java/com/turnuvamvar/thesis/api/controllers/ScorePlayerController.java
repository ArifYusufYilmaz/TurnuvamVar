package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scoreplayer")
public class ScorePlayerController {

    @Autowired
    private ScorePlayerService scorePlayerService;

    public ScorePlayerController(ScorePlayerService scorePlayerService) {
        this.scorePlayerService = scorePlayerService;
    }

    @PostMapping("/save")
    public DataResult<ScorePlayerResponseDto> createOneScorePlayer(@RequestBody ScorePlayerRequestDto newScorePlayerRequestDto){
        return this.scorePlayerService.createOneScorePlayer(newScorePlayerRequestDto);
    }


    @GetMapping("/get/{scorePlayerId}")
    public DataResult<ScorePlayerResponseDto> getOneScorePlayerById(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.getOneScorePlayerById(scorePlayerId);
    }

    @PutMapping("/update/{scorePlayerId}")
    public DataResult<ScorePlayerResponseDto> updateOneScorePlayer(@PathVariable Long scorePlayerId,
                                                                   @RequestBody ScorePlayerRequestDto scorePlayerRequestDto){
        return this.scorePlayerService.updateOneScorePlayer(scorePlayerId, scorePlayerRequestDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<ScorePlayerResponseDto>> getAllScorePlayers(){
        return this.scorePlayerService.getAllScorePlayers();
    }

    @DeleteMapping("/delete/{scorePlayerId}")
    public Result deleteOneScorePlayer(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.deleteOneScorePlayerById(scorePlayerId);
    }

}
