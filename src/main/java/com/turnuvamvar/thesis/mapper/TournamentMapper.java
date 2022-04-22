package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TournamentMapper {
    @Autowired
    protected TournamentService tournamentService;

    public abstract TournamentDto mapTournamentToTournamentDto(Tournament tournament);

    public abstract Tournament mapTournamentDtoToTournament(TournamentDto tournamentDto);

    public abstract List<TournamentDto> mapTournamentListToTournamentDtoList(Collection<Tournament> tournaments);
    public abstract List<Tournament> mapTournamentDtoListToTournamentList(Collection<TournamentDto> tournamentDtos);
}
