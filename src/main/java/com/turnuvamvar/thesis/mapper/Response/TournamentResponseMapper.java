package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TournamentResponseMapper {


    public abstract TournamentResponseDto mapTournamentToTournamentResponseDto(Tournament tournament);

    public abstract Tournament mapTournamentResponseDtoToTournament(TournamentResponseDto tournamentResponseDto);

    public abstract List<TournamentResponseDto> mapTournamentListToTournamentResponseDtoList(Collection<Tournament> tournaments);
    public abstract List<Tournament> mapTournamentResponseDtoListToTournamentList(Collection<TournamentResponseDto> tournamentResponseDtos);
}
