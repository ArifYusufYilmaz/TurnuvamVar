package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.ErrorDataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamManager implements TeamService {
    @Autowired
    private TeamDao teamDao;

    private TournamentDao tournamentDao;

    private TeamMapper teamMapper;

    @Autowired
    public TeamManager(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    @Autowired
    public void setTournamentDao(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }
    @Autowired
    public void setTeamMapper(@Lazy TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Override
    public DataResult<List<TeamDto>> getAllTeams() {    //düzenlenecek!
        //this.teamDao.findAll()
        return new SuccessDataResult<List<TeamDto>>();
    }


    @Override
    public DataResult<TeamDto> createOneTeam(Long tournamentId, TeamDto newTeamDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);

        if(tournament.isPresent()){
            Team newTeam = teamMapper.mapTeamDtoToTeam(newTeamDto);
            newTeam.setTournament(tournament.get());

            newTeam.getTeamCaptain().setCaptainFirstName(newTeam.getCaptainFirstName());
            newTeam.getTeamCaptain().setCaptainLastName(newTeam.getCaptainLastName());

            newTeamDto = teamMapper.mapTeamToTeamDto(this.teamDao.save(newTeam));
            return new SuccessDataResult<TeamDto>(newTeamDto);
        }
        else{
            //error mesajı düzenlenebilir.
            return new ErrorDataResult<TeamDto>("verilen id'de turnuva bulunamadı..");
        }

    }
}
