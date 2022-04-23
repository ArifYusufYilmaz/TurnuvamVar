package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping
    public DataResult<List<TeamDto>> getAllTeams(){
        return this.teamService.getAllTeams();
    }
    @PostMapping("/{tournamentId}")
    public DataResult<TeamDto> createOneTeam(@PathVariable Long tournamentId, @RequestBody TeamDto newTeamDto){
        return this.teamService.createOneTeam(tournamentId, newTeamDto);
    }
}
