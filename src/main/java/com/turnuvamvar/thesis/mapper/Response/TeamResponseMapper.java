package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeamResponseMapper {


  //  @Mapping(source = "teamCaptain.id", target = "teamCaptainId")
    public abstract TeamResponseDto mapTeamToTeamResponseDto(Team team);
  //  @Mapping(source = "teamCaptainId", target = "teamCaptain.id")
    public abstract Team mapTeamResponseDtoToTeam(TeamResponseDto teamResponseDto);

    public abstract List<TeamResponseDto> mapTeamListToTeamResponseDtoList(Collection<Team> teams);
    public abstract List<Team> mapTeamResponseDtoListToTeamList(Collection<TeamResponseDto> teamResponseDtos);

}
