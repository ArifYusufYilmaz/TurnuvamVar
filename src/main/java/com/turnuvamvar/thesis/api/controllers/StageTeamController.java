package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/stageteam")
public class StageTeamController {
    @Autowired
    private StageTeamService stageTeamService;
    @Autowired
    public StageTeamController(StageTeamService stageTeamService) {
        this.stageTeamService = stageTeamService;
    }

    @PostMapping("/save")
    public DataResult<StageTeamResponseDto> createOneStageTeam(@RequestBody StageTeamResponseDto newStageTeamResponseDto){
        return this.stageTeamService.createOneStageTeam(newStageTeamResponseDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<StageTeamRequestDto>> getAllStagesTeams(){
        return this.stageTeamService.getAllStagesTeams();
    }

    @GetMapping("/get/{stageTeamId}")
    public DataResult<StageTeamRequestDto> getOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.getOneStageTeamById(stageTeamId);
    }

    @PutMapping("/update/{stageTeamId}")
    public DataResult<StageTeamResponseDto> updateOneStageTeam(@PathVariable Long stageTeamId, @RequestBody StageTeamResponseDto stageTeamResponseDto){
        return this.stageTeamService.updateOneStageTeam(stageTeamId, stageTeamResponseDto);
    }


    @DeleteMapping("/delete/{stageTeamId}")
    public Result deleteOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.deleteOneStageTeamById(stageTeamId);
    }
}
