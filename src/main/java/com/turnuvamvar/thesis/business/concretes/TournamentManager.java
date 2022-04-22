package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentManager implements TournamentService {

    private TournamentDao tournamentDao;
    @Autowired
    public TournamentManager(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }

    @Override
    public DataResult<List<Tournament>> getAllTournaments() {
        return new SuccessDataResult<List<Tournament>>(this.tournamentDao.findAll());
    }

    @Override
    public DataResult<Tournament> createOneTournament(Tournament newTournament) {
        return new SuccessDataResult<Tournament>(this.tournamentDao.save(newTournament));
    }
}
