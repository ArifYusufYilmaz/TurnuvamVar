package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoresplayers")
public class ScorePlayerController {

    @Autowired
    private ScorePlayerService scorePlayerService;

    public ScorePlayerController(ScorePlayerService scorePlayerService) {
        this.scorePlayerService = scorePlayerService;
    }

    @PostMapping
    public DataResult<ScorePlayerDto> createOneScorePlayer(@RequestBody ScorePlayerDto newScorePlayerDto){
        return this.scorePlayerService.createOneScorePlayer(newScorePlayerDto);
    }


    @GetMapping("/{scorePlayerId}")
    public DataResult<ScorePlayer> getOneScorePlayerById(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.getOneScorePlayerById(scorePlayerId);
    }

    @PutMapping("/update/{scorePlayerId}")
    public DataResult<ScorePlayerDto> updateOneScorePlayer(@PathVariable Long scorePlayerId,
                                                               @RequestBody ScorePlayerDto scorePlayerDto){
        return this.scorePlayerService.updateOneScorePlayer(scorePlayerId, scorePlayerDto);
    }
    @GetMapping
    public DataResult<List<ScorePlayer>> getAllScorePlayers(){
        return this.scorePlayerService.getAllScorePlayers();
    }

    @DeleteMapping("/delete/{scorePlayerId}")
    public Result deleteOneScorePlayer(@PathVariable Long scorePlayerId){
        return this.scorePlayerService.deleteOneScorePlayerById(scorePlayerId);
    }

}
