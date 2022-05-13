package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stagesteams")
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
    @GetMapping
    public DataResult<List<StageTeam>> getAllStagesTeams(){
        return this.stageTeamService.getAllStagesTeams();
    }

    @GetMapping("/{stageTeamId}")
    public DataResult<StageTeam> getOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.getOneStageTeamById(stageTeamId);
    }

    @PutMapping("/update/{gameToPlayId}")
    public DataResult<StageTeamDto> updateOneStageTeam(@PathVariable Long stageTeamId, @RequestBody StageTeamDto stageTeamDto){
        return this.stageTeamService.updateOneStageTeam(stageTeamId, stageTeamDto);
    }


    @DeleteMapping("/delete/{stageTeamId}")
    public Result deleteOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.deleteOneStageTeamById(stageTeamId);
    }
}
