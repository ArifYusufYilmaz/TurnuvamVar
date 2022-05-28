package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StageTeamRequestMapper {

    @Mapping(source="stage.id",target="stageId")
    @Mapping(source="team.id",target="teamId")
    public abstract StageTeamRequestDto mapStageTeamToStageTeamRequestDto(StageTeam stageTeam);
    @Mapping(source="stageId",target="stage.id")
    @Mapping(source="teamId",target="team.id")
    public abstract StageTeam mapStageTeamRequestDtoToStage(StageTeamRequestDto stageTeamRequestDto);

    public abstract List<StageTeam> mapStageTeamRequestDtoListToStageTeamList(Collection<StageTeamRequestDto> stageTeamRequestDtoList);
    public abstract List<StageTeamRequestDto> mapStageTeamListToStageTeamRequestDtoList(Collection<StageTeam> stageTeamList);
}
