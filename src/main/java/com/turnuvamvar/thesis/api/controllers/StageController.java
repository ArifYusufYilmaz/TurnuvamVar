package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {
    @Autowired
    private StageService stageService;
    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }
    @GetMapping("/get/list")
    public DataResult<List<StageResponseDto>> getAllStages(@RequestParam(required = false) Long tournamentId){
        return this.stageService.getAllStages(tournamentId);
    }

    @GetMapping("/get/{stageId}")
    public DataResult<StageResponseDto> getOneStageById(@PathVariable Long stageId){
        return this.stageService.getOneStageById(stageId);
    }

    @PutMapping("/update/{stageId}")
    public DataResult<StageResponseDto> updateOneStage(@PathVariable Long stageId, @RequestBody StageRequestDto stageRequestDto){
        return this.stageService.updateOneStage(stageId, stageRequestDto);
    }

    @PostMapping("/save/{tournamentId}")
    public DataResult<StageResponseDto> createOneStage(@PathVariable Long tournamentId, @RequestBody StageRequestDto newStageRequestDto){
        return this.stageService.createOneStage(tournamentId, newStageRequestDto);
    }
    @DeleteMapping("/delete/{stageId}")
    public Result deleteOneStage(@PathVariable Long stageId){
        return this.stageService.deleteOneStageById(stageId);
    }

}
