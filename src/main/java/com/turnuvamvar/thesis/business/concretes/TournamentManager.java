package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.TournamentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentManager implements TournamentService {
    @Autowired
    private TournamentDao tournamentDao;

    private  TournamentMapper tournamentMapper;

    @Autowired
    public TournamentManager(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }
    @Autowired
    public void setTournamentMapper(@Lazy TournamentMapper tournamentMapper) {
        this.tournamentMapper = tournamentMapper;
    }

    @Override
    public DataResult<List<TournamentDto>> getAllTournaments() {
        return new SuccessDataResult<List<Tournament>>(this.tournamentDao.findAll());
    }

    @Override
    public DataResult<TournamentDto> createOneTournament(TournamentDto newTournamentDto) {
        Tournament tournament = tournamentMapper.mapTournamentDtoToTournament(newTournamentDto);
        TournamentDto tournamentDto = tournamentMapper.mapTournamentToTournamentDto(this.tournamentDao.save(tournament));
        return new SuccessDataResult<TournamentDto>(tournamentDto);

    }
}
