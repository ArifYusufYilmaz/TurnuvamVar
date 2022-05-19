package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-19T21:45:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl extends TeamMapper {

    @Override
    public TeamDto mapTeamToTeamDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setTeamName( team.getTeamName() );
        teamDto.setCaptainFirstName( team.getCaptainFirstName() );
        teamDto.setCaptainLastName( team.getCaptainLastName() );

        return teamDto;
    }

    @Override
    public Team mapTeamDtoToTeam(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( teamDto.getTeamName() );
        team.setCaptainFirstName( teamDto.getCaptainFirstName() );
        team.setCaptainLastName( teamDto.getCaptainLastName() );

        return team;
    }

    @Override
    public List<TeamDto> mapTeamListToTeamDtoList(Collection<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamDto> list = new ArrayList<TeamDto>( teams.size() );
        for ( Team team : teams ) {
            list.add( mapTeamToTeamDto( team ) );
        }

        return list;
    }

    @Override
    public List<Team> mapTeamDtoListToTeamList(Collection<TeamDto> teamDtos) {
        if ( teamDtos == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamDtos.size() );
        for ( TeamDto teamDto : teamDtos ) {
            list.add( mapTeamDtoToTeam( teamDto ) );
        }

        return list;
    }
}
