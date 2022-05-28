package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StageResponseMapper {
    public abstract StageResponseDto mapStageToStageResponseDto(Stage stage);
    public abstract Stage mapStageResponseDtoToStage(StageResponseDto stageResponseDto);
}
