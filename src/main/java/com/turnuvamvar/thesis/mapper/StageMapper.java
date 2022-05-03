package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StageMapper {
    public abstract StageDto mapStageToStageDto(Stage stage);
    public abstract Stage mapStageDtoToStage(StageDto stageDto);
}
