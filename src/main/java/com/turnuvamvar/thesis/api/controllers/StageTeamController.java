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
    public DataResult<StageTeamResponseDto> createOneStageTeam(@RequestBody StageTeamRequestDto newStageTeamRequestDto){
        return this.stageTeamService.createOneStageTeam(newStageTeamRequestDto);
    }
    @GetMapping("/get/list")
    public DataResult<List<StageTeamResponseDto>> getAllStagesTeams(@RequestParam(required=false)Long stageId){
        return this.stageTeamService.getAllStagesTeams(stageId);
    }
    @GetMapping("/get/{stageTeamId}")
    public DataResult<StageTeamResponseDto> getOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.getOneStageTeamById(stageTeamId);
    }
    @PutMapping("/update/{stageTeamId}")
    public DataResult<StageTeamResponseDto> updateOneStageTeam(@PathVariable Long stageTeamId, @RequestBody StageTeamRequestDto stageTeamRequestDto){
        return this.stageTeamService.updateOneStageTeam(stageTeamId, stageTeamRequestDto);
    }
    @DeleteMapping("/delete/{stageTeamId}")
    public Result deleteOneStageTeamById(@PathVariable Long stageTeamId){
        return this.stageTeamService.deleteOneStageTeamById(stageTeamId);
    }
}
