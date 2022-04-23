package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeamMapper {
    @Autowired
    protected TeamService teamService;

    @Mapping(source = "teamCaptain.id", target = "teamCaptainId")
    public abstract TeamDto mapTeamToTeamDto(Team team);
    @Mapping(source = "teamCaptainId", target = "teamCaptain.id")
    public abstract Team mapTeamDtoToTeam(TeamDto teamDto);

    public abstract List<TeamDto> mapTeamListToTeamDtoList(Collection<Team> team);
    public abstract List<Team> mapTeamDtoListToTeamList(Collection<TeamDto> teamDto);

}
