package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.ScorePlayerService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scoreplayer")
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
}
