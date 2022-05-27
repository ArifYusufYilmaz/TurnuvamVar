package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TournamentRequestMapper {
    public abstract TournamentRequestDto mapTournamentToTournamentRequestDto(Tournament tournament);

    public abstract Tournament mapTournamentRequestDtoToTournament(TournamentRequestDto tournamentRequestDto);

    public abstract List<TournamentRequestDto> mapTournamentListToTournamentRequestDtoList(Collection<Tournament> tournaments);
    public abstract List<Tournament> mapTournamentRequestDtoListToTournamentList(Collection<TournamentRequestDto> tournamentRequestDtos);
}
