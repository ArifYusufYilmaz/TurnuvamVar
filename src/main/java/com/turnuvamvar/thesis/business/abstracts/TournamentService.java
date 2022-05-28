package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;

import java.util.List;

public interface TournamentService {
    DataResult<List<TournamentResponseDto>> getAllTournaments();

    DataResult<TournamentResponseDto> createOneTournament(TournamentRequestDto newTournamentRequestDto);

    DataResult<TournamentResponseDto> getOneTournementById(Long tournamentId);

    DataResult<TournamentResponseDto> updateOneTournement(Long tournamentId, TournamentRequestDto tournamentRequestDto);

    Result deleteOneTournementById(Long tournamentId);
}
