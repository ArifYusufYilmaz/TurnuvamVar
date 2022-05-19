package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeamRequestMapper {
    @Mapping(source = "teamCaptain.id", target = "teamCaptainId")
    @Mapping(source = "tournament.id", target = "tournamentId")
    public abstract TeamRequestDto mapTeamToTeamRequestDto(Team team);
    @Mapping(source = "teamCaptainId", target = "teamCaptain.id")
    @Mapping(source = "tournamentId", target = "tournament.id")
    public abstract Team mapTeamRequestDtoToTeam(TeamRequestDto teamDto);

    public abstract List<TeamRequestDto> mapTeamListToTeamRequestDtoList(Collection<Team> teams);
    public abstract List<Team> mapTeamRequestDtoListToTeamList(Collection<TeamRequestDto> teamRequestDtos);
}
