package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-23T16:13:18+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TournamentMapperImpl extends TournamentMapper {

    @Override
    public TournamentDto mapTournamentToTournamentDto(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentDto tournamentDto = new TournamentDto();

        tournamentDto.setId( tournament.getId() );
        tournamentDto.setTournamentName( tournament.getTournamentName() );
        tournamentDto.setDescription( tournament.getDescription() );

        return tournamentDto;
    }

    @Override
    public Tournament mapTournamentDtoToTournament(TournamentDto tournamentDto) {
        if ( tournamentDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setId( tournamentDto.getId() );
        tournament.setTournamentName( tournamentDto.getTournamentName() );
        tournament.setDescription( tournamentDto.getDescription() );

        return tournament;
    }

    @Override
    public List<TournamentDto> mapTournamentListToTournamentDtoList(Collection<Tournament> tournaments) {
        if ( tournaments == null ) {
            return null;
        }

        List<TournamentDto> list = new ArrayList<TournamentDto>( tournaments.size() );
        for ( Tournament tournament : tournaments ) {
            list.add( mapTournamentToTournamentDto( tournament ) );
        }

        return list;
    }

    @Override
    public List<Tournament> mapTournamentDtoListToTournamentList(Collection<TournamentDto> tournamentDtos) {
        if ( tournamentDtos == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( tournamentDtos.size() );
        for ( TournamentDto tournamentDto : tournamentDtos ) {
            list.add( mapTournamentDtoToTournament( tournamentDto ) );
        }

        return list;
    }
}
