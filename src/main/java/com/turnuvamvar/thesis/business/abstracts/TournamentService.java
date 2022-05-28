package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;

import java.util.List;

public interface TournamentService {
    DataResult<List<TournamentRequestDto>> getAllTournaments();

    DataResult<TournamentResponseDto> createOneTournament(TournamentResponseDto newTournamentResponseDto);

    DataResult<TournamentRequestDto> getOneTournementById(Long tournamentId);

    DataResult<TournamentResponseDto> updateOneTournement(Long tournamentId, TournamentResponseDto tournamentResponseDto);

    Result deleteOneTournementById(Long tournamentId);
}
