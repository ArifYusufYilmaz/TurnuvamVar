package com.turnuvamvar.thesis.api.controllers;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.dto.TournamentDto;
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

    @GetMapping("/list")
    public DataResult<List<TournamentDto>> getAllTournaments(){
        return this.tournamentService.getAllTournaments();
    }
    @PostMapping("/save")
    public DataResult<TournamentDto> createOneTournament(@RequestBody TournamentDto newTournamentDto){
        return this.tournamentService.createOneTournament(newTournamentDto);
    }


}
