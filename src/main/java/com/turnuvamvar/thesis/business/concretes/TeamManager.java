package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.TeamDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.Request.TeamRequestMapper;
import com.turnuvamvar.thesis.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamManager implements TeamService {
    @Autowired
    private TeamDao teamDao;

    private TournamentDao tournamentDao;

    private TeamMapper teamMapper;
    private TeamRequestMapper teamRequestMapper;

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
    @Autowired
    public void setTeamRequestMapper(TeamRequestMapper teamRequestMapper) {
        this.teamRequestMapper = teamRequestMapper;
    }

    @Override
    public DataResult<List<TeamRequestDto>> getAllTeams() {    //düzenlenecek!
        List<Team> teamList = new ArrayList<>();
        Iterable<Team> teamIterable = this.teamDao.findAll();
        teamIterable.iterator().forEachRemaining( teamList :: add);
        List<TeamRequestDto> teamRequestDtoList =  teamRequestMapper.mapTeamListToTeamRequestDtoList(teamList);

        if(teamRequestDtoList.isEmpty()){
            return new ErrorDataResult<List<TeamRequestDto>>("takım listesinde hiç takım bulunamadı..");
        }else{
            return new SuccessDataResult<List<TeamRequestDto>>(teamRequestDtoList);
        }
    }

    @Override
    public DataResult<List<TeamRequestDto>> getAllTeamsByTournamentId(Long tournamentId) {
        List<Team> teamList = new ArrayList<>();
        List<Team> teamsInTournament =  this.teamDao.findAllByTournamentId(tournamentId);
        Iterable<Team> teamIterable = teamsInTournament;
        teamIterable.iterator().forEachRemaining(teamList :: add);
        List<TeamRequestDto> teamRequestDtoList = teamRequestMapper.mapTeamListToTeamRequestDtoList(teamList);
        if(teamRequestDtoList.isEmpty()){
            return new ErrorDataResult<List<TeamRequestDto>>("takım listesinde hiç takım bulunamadı..");
        }else{
            return new SuccessDataResult<List<TeamRequestDto>>(teamRequestDtoList);
        }
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

    @Override
    public DataResult<Team> getOneTeamById(Long teamId) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            return new SuccessDataResult<Team>(team.get());
        }else{
            return new ErrorDataResult<Team>("takım bulunamadı..");
        }
    }

    @Override
    public DataResult<TeamDto> updateOneTeam(Long teamId, TeamDto teamDto) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            Team toSave = team.get();
            toSave.setTeamName(teamDto.getTeamName());
            toSave.setCaptainFirstName(teamDto.getCaptainFirstName());
            toSave.setCaptainLastName(teamDto.getCaptainLastName());
            toSave = this.teamDao.save(toSave);
            TeamDto newTeamDto = teamMapper.mapTeamToTeamDto(toSave);
            return new SuccessDataResult<TeamDto>(newTeamDto);
        }else{
            return new ErrorDataResult<TeamDto>("takım bulunamadı");
        }

    }

    @Override
    public Result deleteOneTeamById(Long teamId) {
        // takımla bağlantılı olan diğer şeyler silinmeli mi ???

        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            this.teamDao.deleteById(team.get().getId());
            return new SuccessResult("verilen id'ye ait takım silindi");
        }
        else{
            return new ErrorResult("verilen id'ye ait takım bulunamadı");
        }
    }
}
