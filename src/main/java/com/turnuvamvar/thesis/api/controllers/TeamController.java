package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teams")
//crossorigin kaldırıldı
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping("/get/list")
    public DataResult<List<TeamDto>> getAllTeams(){
        return this.teamService.getAllTeams();
    }
    @GetMapping("/get/{teamId}")
    public DataResult<Team> getOneTeamById(@PathVariable Long teamId){
        return this.teamService.getOneTeamById(teamId);
    }
    @PutMapping("/update/{teamId}")
    public DataResult<TeamDto> updateOneTeam(@PathVariable Long teamId, @RequestBody TeamDto teamDto){
        return this.teamService.updateOneTeam(teamId, teamDto);
    }
    @PostMapping("/save/{tournamentId}")
    public DataResult<TeamDto> createOneTeam(@PathVariable Long tournamentId, @RequestBody TeamDto newTeamDto){
        return this.teamService.createOneTeam(tournamentId, newTeamDto);
    }
    @DeleteMapping("/delete/{teamId}")
    public Result deleteOneTeam(@PathVariable Long teamId){
        return this.teamService.deleteOneTeamById(teamId);
    }
}
