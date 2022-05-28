package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StageTeamResponseMapper {
    @Mapping(source="stage.id",target="stageId")
    @Mapping(source="stage.stageName",target="stageName")
    @Mapping(source="team.id",target="teamId")
    @Mapping(source="team.teamName",target="teamName")
    public abstract StageTeamResponseDto mapStageTeamToStageTeamResponseDto(StageTeam stageTeam);
    @Mapping(source="stageId",target="stage.id")
    @Mapping(source="stageName",target="stage.stageName")
    @Mapping(source="teamId",target="team.id")
    @Mapping(source="teamName",target="team.teamName")
    public abstract StageTeam mapStageTeamResponseDtoToStageTeam(StageTeamResponseDto stageTeamResponseDto);

    public abstract List<StageTeam> mapStageTeamResponseDtoListToStageTeamList(Collection<StageTeamResponseDto> stageTeamResponseDtoList);
    public abstract List<StageTeamResponseDto> mapStageTeamListToStageTeamResponseDtoList(Collection<StageTeam> stageTeamList);
}
