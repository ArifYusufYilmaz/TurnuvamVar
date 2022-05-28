package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;

import java.util.List;

public interface TeamService {
    DataResult<List<TeamRequestDto>> getAllTeams(Long tournamentId);
    DataResult<List<TeamRequestDto>> getAllTeamsByTournamentId(Long tournamentId);

    DataResult<TeamResponseDto> createOneTeam(Long tournamentId, TeamResponseDto newTeamResponseDto);

    DataResult<TeamRequestDto> getOneTeamById(Long teamId);

    DataResult<TeamResponseDto> updateOneTeam(Long teamId, TeamResponseDto teamResponseDto);

    Result deleteOneTeamById(Long teamId);
}
