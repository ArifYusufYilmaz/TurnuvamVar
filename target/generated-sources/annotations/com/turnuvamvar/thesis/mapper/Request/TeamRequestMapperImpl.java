package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.TeamCaptain;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-19T21:59:50+0300",
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

        teamRequestDto.setTeamCaptainId( teamTeamCaptainId( team ) );
        teamRequestDto.setTournamentId( teamTournamentId( team ) );
        teamRequestDto.setId( team.getId() );
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

        team.setTeamCaptain( teamRequestDtoToTeamCaptain( teamDto ) );
        team.setTournament( teamRequestDtoToTournament( teamDto ) );
        team.setId( teamDto.getId() );
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

    private Long teamTeamCaptainId(Team team) {
        if ( team == null ) {
            return null;
        }
        TeamCaptain teamCaptain = team.getTeamCaptain();
        if ( teamCaptain == null ) {
            return null;
        }
        Long id = teamCaptain.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long teamTournamentId(Team team) {
        if ( team == null ) {
            return null;
        }
        Tournament tournament = team.getTournament();
        if ( tournament == null ) {
            return null;
        }
        Long id = tournament.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TeamCaptain teamRequestDtoToTeamCaptain(TeamRequestDto teamRequestDto) {
        if ( teamRequestDto == null ) {
            return null;
        }

        TeamCaptain teamCaptain = new TeamCaptain();

        teamCaptain.setId( teamRequestDto.getTeamCaptainId() );

        return teamCaptain;
    }

    protected Tournament teamRequestDtoToTournament(TeamRequestDto teamRequestDto) {
        if ( teamRequestDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setId( teamRequestDto.getTournamentId() );

        return tournament;
    }
}
