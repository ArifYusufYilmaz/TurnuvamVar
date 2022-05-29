package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
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
    date = "2022-05-29T19:32:57+0300",
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

        teamResponseDto.setTeamCaptainId( teamTeamCaptainId( team ) );
        teamResponseDto.setTournamentName( teamTournamentTournamentName( team ) );
        teamResponseDto.setTournamentId( teamTournamentId( team ) );
        teamResponseDto.setId( team.getId() );
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

        team.setTeamCaptain( teamResponseDtoToTeamCaptain( teamResponseDto ) );
        team.setTournament( teamResponseDtoToTournament( teamResponseDto ) );
        team.setId( teamResponseDto.getId() );
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

    private String teamTournamentTournamentName(Team team) {
        if ( team == null ) {
            return null;
        }
        Tournament tournament = team.getTournament();
        if ( tournament == null ) {
            return null;
        }
        String tournamentName = tournament.getTournamentName();
        if ( tournamentName == null ) {
            return null;
        }
        return tournamentName;
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

    protected TeamCaptain teamResponseDtoToTeamCaptain(TeamResponseDto teamResponseDto) {
        if ( teamResponseDto == null ) {
            return null;
        }

        TeamCaptain teamCaptain = new TeamCaptain();

        teamCaptain.setId( teamResponseDto.getTeamCaptainId() );

        return teamCaptain;
    }

    protected Tournament teamResponseDtoToTournament(TeamResponseDto teamResponseDto) {
        if ( teamResponseDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setTournamentName( teamResponseDto.getTournamentName() );
        tournament.setId( teamResponseDto.getTournamentId() );

        return tournament;
    }
}
