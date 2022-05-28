package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeamRequestMapper {
    public abstract TeamRequestDto mapTeamToTeamRequestDto(Team team);
    public abstract Team mapTeamRequestDtoToTeam(TeamRequestDto teamDto);

    public abstract List<TeamRequestDto> mapTeamListToTeamRequestDtoList(Collection<Team> teams);
    public abstract List<Team> mapTeamRequestDtoListToTeamList(Collection<TeamRequestDto> teamRequestDtos);
}
