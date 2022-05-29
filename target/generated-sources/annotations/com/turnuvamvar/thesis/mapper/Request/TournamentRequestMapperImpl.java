package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
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
public class TournamentRequestMapperImpl extends TournamentRequestMapper {

    @Override
    public TournamentRequestDto mapTournamentToTournamentRequestDto(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentRequestDto tournamentRequestDto = new TournamentRequestDto();

        tournamentRequestDto.setTournamentName( tournament.getTournamentName() );
        tournamentRequestDto.setDescription( tournament.getDescription() );

        return tournamentRequestDto;
    }

    @Override
    public Tournament mapTournamentRequestDtoToTournament(TournamentRequestDto tournamentRequestDto) {
        if ( tournamentRequestDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setTournamentName( tournamentRequestDto.getTournamentName() );
        tournament.setDescription( tournamentRequestDto.getDescription() );

        return tournament;
    }

    @Override
    public List<TournamentRequestDto> mapTournamentListToTournamentRequestDtoList(Collection<Tournament> tournaments) {
        if ( tournaments == null ) {
            return null;
        }

        List<TournamentRequestDto> list = new ArrayList<TournamentRequestDto>( tournaments.size() );
        for ( Tournament tournament : tournaments ) {
            list.add( mapTournamentToTournamentRequestDto( tournament ) );
        }

        return list;
    }

    @Override
    public List<Tournament> mapTournamentRequestDtoListToTournamentList(Collection<TournamentRequestDto> tournamentRequestDtos) {
        if ( tournamentRequestDtos == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( tournamentRequestDtos.size() );
        for ( TournamentRequestDto tournamentRequestDto : tournamentRequestDtos ) {
            list.add( mapTournamentRequestDtoToTournament( tournamentRequestDto ) );
        }

        return list;
    }
}
