package com.turnuvamvar.thesis.business.abstracts;

import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;

import java.util.List;

public interface TeamService {
    DataResult<List<TeamDto>> getAllTeams();

    DataResult<TeamDto> createOneTeam(Long tournamentId, TeamDto newTeamDto);

    DataResult<Team> getOneTeamById(Long teamId);

    DataResult<TeamDto> updateOneTeam(Long teamId, TeamDto teamDto);

    Result deleteOneTeamById(Long teamId);
}
