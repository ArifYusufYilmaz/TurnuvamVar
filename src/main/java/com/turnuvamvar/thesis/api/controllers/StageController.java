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
    public DataResult<List<StageResponseDto>> getAllStages(){
        return this.stageService.getAllStages();
    }

    @GetMapping("/get/{stageId}")
    public DataResult<StageResponseDto> getOneStageById(@PathVariable Long stageId){
        return this.stageService.getOneStageById(stageId);
    }

    @PutMapping("/update/{stageId}")
    public DataResult<StageResponseDto> updateOneStage(@PathVariable Long stageId, @RequestBody StageRequestDto stageRequestDto){
        return this.stageService.updateOneStage(stageId, stageRequestDto);
    }

    @PostMapping("/save")
    public DataResult<StageResponseDto> createOneStage(@RequestBody StageRequestDto newStageRequestDto){
        return this.stageService.createOneStage(newStageRequestDto);
    }
    @DeleteMapping("/delete/{stageId}")
    public Result deleteOneStage(@PathVariable Long stageId){
        return this.stageService.deleteOneStageById(stageId);
    }

}
