package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StageRequestMapper {
    public abstract StageRequestDto mapStageToStageRequestDto(Stage stage);
    public abstract Stage mapStageRequestDtoToStage(StageRequestDto stageRequestDto);
    public abstract List<StageRequestDto> mapStageListToStageRequestDtoList(Collection<Stage> stageList);
    public abstract List<Stage> mapStageRequestDtoListToStageList(Collection<StageRequestDto> stageRequestDtoList);
}
