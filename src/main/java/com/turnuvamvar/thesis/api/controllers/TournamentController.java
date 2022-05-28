package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = {"*"}, allowCredentials = "false")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/get/{tournamentId}")
    public DataResult<TournamentResponseDto> getOneTournementById(@PathVariable Long tournamentId ){
        return this.tournamentService.getOneTournementById(tournamentId);
    }
    @PutMapping("/update/{tournamentId}")
    public DataResult<TournamentResponseDto> updateOneTournement(@PathVariable Long tournamentId, @RequestBody TournamentRequestDto tournamentRequestDto){
        return this.tournamentService.updateOneTournement(tournamentId, tournamentRequestDto);
    }

    @GetMapping("/get/list")
    public DataResult<List<TournamentResponseDto>> getAllTournaments(){
        return this.tournamentService.getAllTournaments();
    }

    @PostMapping("/save")
    public DataResult<TournamentResponseDto> createOneTournament(@RequestBody TournamentRequestDto newTournamentRequestDto){
        return this.tournamentService.createOneTournament(newTournamentRequestDto);
    }

    @DeleteMapping("/delete/{tournamentId}")
    public Result deleteOneTournement(@PathVariable Long tournamentId){
        return this.tournamentService.deleteOneTournementById(tournamentId);
    }

}
