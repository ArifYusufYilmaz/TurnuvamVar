package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.StageTeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stageteam")
public class StageTeamController {
    @Autowired
    private StageTeamService stageTeamService;
    @Autowired
    public StageTeamController(StageTeamService stageTeamService) {
        this.stageTeamService = stageTeamService;
    }

    @PostMapping("/save")
    public DataResult<StageTeamDto> createOneStageTeam(StageTeamDto newStageTeamDto){
        return this.stageTeamService.createOneStageTeam(newStageTeamDto);
    }
}
