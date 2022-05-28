package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T21:33:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TeamResponseMapperImpl extends TeamResponseMapper {

    @Override
    public TeamResponseDto mapTeamToTeamResponseDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamResponseDto teamResponseDto = new TeamResponseDto();

        teamResponseDto.setTeamName( team.getTeamName() );
        teamResponseDto.setCaptainFirstName( team.getCaptainFirstName() );
        teamResponseDto.setCaptainLastName( team.getCaptainLastName() );

        return teamResponseDto;
    }

    @Override
    public Team mapTeamResponseDtoToTeam(TeamResponseDto teamResponseDto) {
        if ( teamResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( teamResponseDto.getTeamName() );
        team.setCaptainFirstName( teamResponseDto.getCaptainFirstName() );
        team.setCaptainLastName( teamResponseDto.getCaptainLastName() );

        return team;
    }

    @Override
    public List<TeamResponseDto> mapTeamListToTeamResponseDtoList(Collection<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamResponseDto> list = new ArrayList<TeamResponseDto>( teams.size() );
        for ( Team team : teams ) {
            list.add( mapTeamToTeamResponseDto( team ) );
        }

        return list;
    }

    @Override
    public List<Team> mapTeamResponseDtoListToTeamList(Collection<TeamResponseDto> teamResponseDtos) {
        if ( teamResponseDtos == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamResponseDtos.size() );
        for ( TeamResponseDto teamResponseDto : teamResponseDtos ) {
            list.add( mapTeamResponseDtoToTeam( teamResponseDto ) );
        }

        return list;
    }
}
