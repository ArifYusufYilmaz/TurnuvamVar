package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;

import java.util.List;

public interface TournamentService {
    DataResult<List<TournamentDto>> getAllTournaments();

    DataResult<TournamentDto> createOneTournament(TournamentDto newTournamentDto);

    DataResult<Tournament> getOneTournementById(Long tournamentId);

    DataResult<TournamentDto> updateOneTournement(Long tournamentId, TournamentDto tournamentDto);

    Result deleteOneTournementById(Long tournamentId);
}
