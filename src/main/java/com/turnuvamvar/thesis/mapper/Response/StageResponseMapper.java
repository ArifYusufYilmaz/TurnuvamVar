package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StageResponseMapper {
    public abstract StageResponseDto mapStageToStageResponseDto(Stage stage);
    public abstract Stage mapStageResponseDtoToStage(StageResponseDto stageResponseDto);
    public abstract List<StageResponseDto> mapStageListToStageResponseDtoList(Collection<Stage> stageList);
    public abstract List<Stage> mapStageResponseDtoListToStageList(Collection<StageResponseDto> stageResponseDtoList);
}
