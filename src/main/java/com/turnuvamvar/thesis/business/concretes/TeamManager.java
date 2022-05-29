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
    public DataResult<List<TeamResponseDto>> getAllTeams(Long tournamentId) {    //düzenlenecek!
        List<Team> teamList = new ArrayList<>();
        Iterable<Team> teamIterable;
        if(tournamentId == null){
             teamIterable = this.teamDao.findAll();
        }else{
             teamIterable   =   this.teamDao.findAllByTournamentId(tournamentId);
        }

        teamIterable.iterator().forEachRemaining( teamList :: add);

        if(teamList.isEmpty()){
            return new ErrorDataResult<List<TeamResponseDto>>("takım listesinde hiç takım bulunamadı..");
        }else{
            List<TeamResponseDto> teamResponseDtoList =  this.teamResponseMapper.mapTeamListToTeamResponseDtoList(teamList);
            return new SuccessDataResult<List<TeamResponseDto>>(teamResponseDtoList);
        }
    }

    @Override
    public DataResult<List<TeamResponseDto>> getAllTeamsByTournamentId(Long tournamentId) {
        List<Team> teamList = new ArrayList<>();
        List<Team> teamsInTournament =  this.teamDao.findAllByTournamentId(tournamentId);
        Iterable<Team> teamIterable = teamsInTournament;
        teamIterable.iterator().forEachRemaining(teamList :: add);
        if(teamList.isEmpty()){
            return new ErrorDataResult<List<TeamResponseDto>>("takım listesinde hiç takım bulunamadı..");
        }else{
            List<TeamResponseDto> teamResponseDtoList = this.teamResponseMapper.mapTeamListToTeamResponseDtoList(teamList);
            return new SuccessDataResult<List<TeamResponseDto>>(teamResponseDtoList);
        }
    }


    @Override
    public DataResult<TeamResponseDto> createOneTeam(Long tournamentId, TeamRequestDto newTeamRequestDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);

        if(tournament.isPresent()){
            if(newTeamRequestDto == null){
                return new ErrorDataResult<TeamResponseDto>("istek null");
            }else {
                Team newTeam = this.teamRequestMapper.mapTeamRequestDtoToTeam(newTeamRequestDto);
                newTeam.setTournament(tournament.get());

                newTeam.getTeamCaptain().setCaptainFirstName(newTeam.getCaptainFirstName());
                newTeam.getTeamCaptain().setCaptainLastName(newTeam.getCaptainLastName());
                newTeam = this.teamDao.save(newTeam);
                TeamResponseDto teamResponseDto = teamResponseMapper.mapTeamToTeamResponseDto(newTeam);
                return new SuccessDataResult<TeamResponseDto>(teamResponseDto);
            }
        }
        else{
            //error mesajı düzenlenebilir.
            return new ErrorDataResult<TeamResponseDto>("verilen id'de turnuva bulunamadı..");
        }

    }

    @Override
    public DataResult<TeamResponseDto> getOneTeamById(Long teamId) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            TeamResponseDto teamResponseDto = teamResponseMapper.mapTeamToTeamResponseDto(team.get());
            return new SuccessDataResult<TeamResponseDto>(teamResponseDto);
        }else{
            return new ErrorDataResult<TeamResponseDto>("takım bulunamadı..");
        }
    }

    @Override
    public DataResult<TeamResponseDto> updateOneTeam(Long teamId, TeamRequestDto teamRequestDto) {
        Optional<Team> team = this.teamDao.findById(teamId);
        if(team.isPresent()){
            Team toSave = team.get();
            toSave.setTeamName(teamRequestDto.getTeamName());
            toSave.setCaptainFirstName(teamRequestDto.getCaptainFirstName());
            toSave.setCaptainLastName(teamRequestDto.getCaptainLastName());
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
