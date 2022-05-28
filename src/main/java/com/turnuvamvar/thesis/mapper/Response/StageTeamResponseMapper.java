package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class StageTeamResponseMapper {
    @Mapping(source="stage.id",target="stageId")
    @Mapping(source="team.id",target="teamId")
    public abstract StageTeamResponseDto mapStageTeamToStageTeamResponseDto(StageTeam stageTeam);
    @Mapping(source="stageId",target="stage.id")
    @Mapping(source="teamId",target="team.id")
    public abstract StageTeam mapStageTeamResponseDtoToStageTeam(StageTeamResponseDto stageTeamResponseDto);
}
