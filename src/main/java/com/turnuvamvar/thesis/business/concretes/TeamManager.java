package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TeamService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.TeamDao;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.Request.TeamRequestDto;
import com.turnuvamvar.thesis.dto.Response.TeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Team;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.Request.TeamRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.TeamResponseMapper;
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

    private TeamResponseMapper teamResponseMapper;
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
    public void setTeamResponseMapper(@Lazy TeamResponseMapper teamResponseMapper) {
        this.teamResponseMapper = teamResponseMapper;
    }
    @Autowired
    public void setTeamRequestMapper(TeamRequestMapper teamRequestMapper) {
        this.teamRequestMapper = teamRequestMapper;
    }

    @Override
    public DataResult<List<TeamRequestDto>> getAllTeams(Long tournamentId) {    //düzenlenecek!
        List<Team> teamList = new ArrayList<>();
        Iterable<Team> teamIterable;
        if(tournamentId == null){
             teamIterable = this.teamDao.findAll();
        }else{
             teamIterable   =   this.teamDao.findAllByTournamentId(tournamentId);
        }

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
        if(teamList.isEmpty()){
            return new ErrorDataResult<List<TeamRequestDto>>("takım listesinde hiç takım bulunamadı..");
        }else{
            List<TeamRequestDto> teamRequestDtoList = teamRequestMapper.mapTeamListToTeamRequestDtoList(teamList);
            return new SuccessDataResult<List<TeamRequestDto>>(teamRequestDtoList);
        }
    }


    @Override
    public DataResult<TeamResponseDto> createOneTeam(Long tournamentId, TeamResponseDto newTeamResponseDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);

        if(tournament.isPresent()){
            Team newTeam = teamResponseMapper.mapTeamResponseDtoToTeam(newTeamResponseDto);
            newTeam.setTournament(tournament.get());

            newTeam.getTeamCaptain().setCaptainFirstName(newTeam.getCaptainFirstName());
            newTeam.getTeamCaptain().setCaptainLastName(newTeam.getCaptainLastName());

            newTeamResponseDto = teamResponseMapper.mapTeamToTeamResponseDto(this.teamDao.save(newTeam));
            return new SuccessDataResult<TeamResponseDto>(newTeamResponseDto);
        }
        else{
            //error mesajı düzenlenebilir.
            return new ErrorDataResult<TeamResponseDto>("verilen id'de turnuva bulunamadı..");
        }

    }

    @Override
    public DataResult<TeamRequestDto> getOneTeamById(Long teamId) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
           TeamRequestDto teamRequestDto = teamRequestMapper.mapTeamToTeamRequestDto(team.get());
            return new SuccessDataResult<TeamRequestDto>(teamRequestDto);
        }else{
            return new ErrorDataResult<TeamRequestDto>("takım bulunamadı..");
        }
    }

    @Override
    public DataResult<TeamResponseDto> updateOneTeam(Long teamId, TeamResponseDto teamResponseDto) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            Team toSave = team.get();
            toSave.setTeamName(teamResponseDto.getTeamName());
            toSave.setCaptainFirstName(teamResponseDto.getCaptainFirstName());
            toSave.setCaptainLastName(teamResponseDto.getCaptainLastName());
            toSave = this.teamDao.save(toSave);
            TeamResponseDto newTeamResponseDto = teamResponseMapper.mapTeamToTeamResponseDto(toSave);
            return new SuccessDataResult<TeamResponseDto>(newTeamResponseDto);
        }else{
            return new ErrorDataResult<TeamResponseDto>("takım bulunamadı");
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
