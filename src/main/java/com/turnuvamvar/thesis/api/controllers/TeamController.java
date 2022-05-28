package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = {"*"}, allowCredentials = "false")
@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping("/get/list")
    public DataResult<List<TeamRequestDto>> getAllTeams(@RequestParam(required=false) Long tournamentId){
        return this.teamService.getAllTeams(tournamentId);
    }
    @GetMapping("/get/list/{tournamentId}")
    public DataResult<List<TeamRequestDto>> getAllTeamsByTournamentId(@PathVariable Long tournamentId){
        return this.teamService.getAllTeamsByTournamentId(tournamentId);
    }
    @GetMapping("/get/{teamId}")
    public DataResult<TeamRequestDto> getOneTeamById(@PathVariable Long teamId){
        return this.teamService.getOneTeamById(teamId);
    }
    @PutMapping("/update/{teamId}")
    public DataResult<TeamResponseDto> updateOneTeam(@PathVariable Long teamId, @RequestBody TeamResponseDto teamResponseDto){
        return this.teamService.updateOneTeam(teamId, teamResponseDto);
    }
    @PostMapping("/save/{tournamentId}")
    public DataResult<TeamResponseDto> createOneTeam(@PathVariable Long tournamentId, @RequestBody TeamResponseDto newTeamResponseDto){
        return this.teamService.createOneTeam(tournamentId, newTeamResponseDto);
    }
    @DeleteMapping("/delete/{teamId}")
    public Result deleteOneTeam(@PathVariable Long teamId){
        return this.teamService.deleteOneTeamById(teamId);
    }
}

