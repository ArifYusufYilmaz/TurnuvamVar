package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
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
    public DataResult<List<Stage>> getAllStages(){
        return this.stageService.getAllStages();
    }

    @GetMapping("/get/{stageId}")
    public DataResult<Stage> getOneStageById(@PathVariable Long stageId){
        return this.stageService.getOneStageById(stageId);
    }

    @PutMapping("/update/{stageId}")
    public DataResult<StageDto> updateOneStage(@PathVariable Long stageId, @RequestBody StageDto stageDto){
        return this.stageService.updateOneStage(stageId, stageDto);
    }

    @PostMapping("/save")
    public DataResult<StageDto> createOneStage(@RequestBody StageDto newStageDto){
        return this.stageService.createOneStage(newStageDto);
    }
    @DeleteMapping("/delete/{stageId}")
    public Result deleteOneStage(@PathVariable Long stageId){
        return this.stageService.deleteOneStageById(stageId);
    }

}
