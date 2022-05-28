package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;

import java.util.List;

public interface TeamService {
    DataResult<List<TeamResponseDto>> getAllTeams(Long tournamentId);
    DataResult<List<TeamResponseDto>> getAllTeamsByTournamentId(Long tournamentId);

    DataResult<TeamResponseDto> createOneTeam(Long tournamentId, TeamRequestDto newTeamRequestDto);

    DataResult<TeamResponseDto> getOneTeamById(Long teamId);

    DataResult<TeamResponseDto> updateOneTeam(Long teamId, TeamRequestDto teamRequestDto);

    Result deleteOneTeamById(Long teamId);
}
