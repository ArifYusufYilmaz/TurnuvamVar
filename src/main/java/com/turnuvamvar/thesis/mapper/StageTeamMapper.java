package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class StageTeamMapper {
    @Mapping(source="stage.id",target="stageId")
    @Mapping(source="team.id",target="teamId")
    public abstract StageTeamDto mapStageTeamToStageTeamDto(StageTeam stageTeam);
    @Mapping(source="stageId",target="stage.id")
    @Mapping(source="teamId",target="team.id")
    public abstract StageTeam mapStageTeamDtoToStageTeam(StageTeamDto stageTeamDto);
}
