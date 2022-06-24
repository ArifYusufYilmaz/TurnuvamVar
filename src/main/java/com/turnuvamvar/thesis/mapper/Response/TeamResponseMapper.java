package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeamResponseMapper {
    @Mapping(source = "teamCaptain.id", target = "teamCaptainId")
    @Mapping(source = "tournament.tournamentName",target = "tournamentName")
    @Mapping(source = "tournament.id", target = "tournamentId")
    public abstract TeamResponseDto mapTeamToTeamResponseDto(Team team);
    @Mapping(source = "teamCaptainId", target ="teamCaptain.id" )
    @Mapping(source = "tournamentName",target = "tournament.tournamentName")
    @Mapping(source = "tournamentId", target = "tournament.id")
    public abstract Team mapTeamResponseDtoToTeam(TeamResponseDto teamResponseDto);
    public abstract List<TeamResponseDto> mapTeamListToTeamResponseDtoList(Collection<Team> teams);
    public abstract List<Team> mapTeamResponseDtoListToTeamList(Collection<TeamResponseDto> teamResponseDtos);
}
