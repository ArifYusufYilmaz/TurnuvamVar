package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-30T13:10:27+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TeamRequestMapperImpl extends TeamRequestMapper {

    @Override
    public TeamRequestDto mapTeamToTeamRequestDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamRequestDto teamRequestDto = new TeamRequestDto();

        teamRequestDto.setTeamName( team.getTeamName() );
        teamRequestDto.setCaptainFirstName( team.getCaptainFirstName() );
        teamRequestDto.setCaptainLastName( team.getCaptainLastName() );

        return teamRequestDto;
    }

    @Override
    public Team mapTeamRequestDtoToTeam(TeamRequestDto teamDto) {
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
    public List<TeamRequestDto> mapTeamListToTeamRequestDtoList(Collection<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamRequestDto> list = new ArrayList<TeamRequestDto>( teams.size() );
        for ( Team team : teams ) {
            list.add( mapTeamToTeamRequestDto( team ) );
        }

        return list;
    }

    @Override
    public List<Team> mapTeamRequestDtoListToTeamList(Collection<TeamRequestDto> teamRequestDtos) {
        if ( teamRequestDtos == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamRequestDtos.size() );
        for ( TeamRequestDto teamRequestDto : teamRequestDtos ) {
            list.add( mapTeamRequestDtoToTeam( teamRequestDto ) );
        }

        return list;
    }
}
