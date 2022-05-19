package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.Result;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.ServerSocket;
import java.util.List;


@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = {"*"}, allowCredentials = "false")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired //daha sonra setter injection yapılabilir.
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/get/{tournamentId}")
    public DataResult<Tournament> getOneTournementById(@PathVariable Long tournamentId ){
        return this.tournamentService.getOneTournementById(tournamentId);
    }
    @PutMapping("/update/{tournamentId}")
    public DataResult<TournamentDto> updateOneTournement(@PathVariable Long tournamentId, @RequestBody TournamentDto tournamentDto){
        return this.tournamentService.updateOneTournement(tournamentId, tournamentDto);
    }

    @GetMapping("/get/list")
    public DataResult<List<TournamentDto>> getAllTournaments(){
        return this.tournamentService.getAllTournaments();
    }

    @PostMapping("/save")
    public DataResult<TournamentDto> createOneTournament(@RequestBody TournamentDto newTournamentDto){
        return this.tournamentService.createOneTournament(newTournamentDto);
    }

    @DeleteMapping("/delete/{tournamentId}")
    public Result deleteOneTournement(@PathVariable Long tournamentId){
        return this.tournamentService.deleteOneTournementById(tournamentId);
    }

}
