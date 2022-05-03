package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.StageService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stage")
public class StageController {
    @Autowired
    private StageService stageService;
    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }
    @PostMapping("/save")
    public DataResult<StageDto> createOneStage(@RequestBody StageDto newStageDto){
        return this.stageService.createOneStage(newStageDto);
    }
}
