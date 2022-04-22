package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.ErrorDataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamManager implements TeamService {
    private TeamDao teamDao;
    private TournamentDao tournamentDao;
    @Autowired

    public TeamManager(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    @Autowired
    public void setTournamentDao(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }

    @Override
    public DataResult<List<Team>> getAllTeams() {
        return new SuccessDataResult<List<Team>>(this.teamDao.findAll());
    }

    @Override
    public DataResult<Team> createOneTeam(Long tournamentId, Team newTeam) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);

        if(tournament.isPresent()){
            newTeam.setTournament(tournament.get());
            Team team = this.teamDao.save(newTeam);

            return new SuccessDataResult<Team>(team);
        }
        else{
            //error mesajı düzenlenebilir.
            return new ErrorDataResult<Team>("verilen id'de turnuva bulunamadı..");
        }

    }
}
