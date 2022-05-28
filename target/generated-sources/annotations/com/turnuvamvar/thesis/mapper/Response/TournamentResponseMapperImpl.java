package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T02:19:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TournamentResponseMapperImpl extends TournamentResponseMapper {

    @Override
    public TournamentResponseDto mapTournamentToTournamentResponseDto(Tournament tournament) {
        if ( tournament == null ) {
            return null;
        }

        TournamentResponseDto tournamentResponseDto = new TournamentResponseDto();

        tournamentResponseDto.setId( tournament.getId() );
        tournamentResponseDto.setTournamentName( tournament.getTournamentName() );
        tournamentResponseDto.setDescription( tournament.getDescription() );

        return tournamentResponseDto;
    }

    @Override
    public Tournament mapTournamentResponseDtoToTournament(TournamentResponseDto tournamentResponseDto) {
        if ( tournamentResponseDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setId( tournamentResponseDto.getId() );
        tournament.setTournamentName( tournamentResponseDto.getTournamentName() );
        tournament.setDescription( tournamentResponseDto.getDescription() );

        return tournament;
    }

    @Override
    public List<TournamentResponseDto> mapTournamentListToTournamentResponseDtoList(Collection<Tournament> tournaments) {
        if ( tournaments == null ) {
            return null;
        }

        List<TournamentResponseDto> list = new ArrayList<TournamentResponseDto>( tournaments.size() );
        for ( Tournament tournament : tournaments ) {
            list.add( mapTournamentToTournamentResponseDto( tournament ) );
        }

        return list;
    }

    @Override
    public List<Tournament> mapTournamentResponseDtoListToTournamentList(Collection<TournamentResponseDto> tournamentResponseDtos) {
        if ( tournamentResponseDtos == null ) {
            return null;
        }

        List<Tournament> list = new ArrayList<Tournament>( tournamentResponseDtos.size() );
        for ( TournamentResponseDto tournamentResponseDto : tournamentResponseDtos ) {
            list.add( mapTournamentResponseDtoToTournament( tournamentResponseDto ) );
        }

        return list;
    }
}
