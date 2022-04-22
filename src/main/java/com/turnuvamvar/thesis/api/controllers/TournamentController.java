package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired //daha sonra setter injection yapılabilir.
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public DataResult<List<Tournament>> getAllTournaments(){
        return this.tournamentService.getAllTournaments();
    }
    @PostMapping
    public DataResult<Tournament> createOneTournament(@RequestBody Tournament newTournament){
        return this.tournamentService.createOneTournament(newTournament);
    }


}
