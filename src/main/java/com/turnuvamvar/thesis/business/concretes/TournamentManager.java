package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.Request.TournamentRequestDto;
import com.turnuvamvar.thesis.dto.Response.TournamentResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.Request.TournamentRequestMapper;
import com.turnuvamvar.thesis.mapper.Response.TournamentResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentManager implements TournamentService {
    @Autowired
    private TournamentDao tournamentDao;

    private TournamentResponseMapper tournamentResponseMapper;
    private TournamentRequestMapper tournamentRequestMapper;
    @Autowired
    public TournamentManager(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }
    @Autowired
    public void setTournamentResponseMapper(@Lazy TournamentResponseMapper tournamentResponseMapper) {
        this.tournamentResponseMapper = tournamentResponseMapper;
    }
    @Autowired
    public void setTournamentRequestMapper(TournamentRequestMapper tournamentRequestMapper) {
        this.tournamentRequestMapper = tournamentRequestMapper;
    }

    @Override
    public DataResult<List<TournamentResponseDto>> getAllTournaments() {
        List<Tournament> tournamentList = new ArrayList<>();
        Iterable<Tournament> tournamentIterable = this.tournamentDao.findAll();
        tournamentIterable.iterator().forEachRemaining(tournamentList :: add);

        if(tournamentList.isEmpty()){
            return new ErrorDataResult<TournamentResponseDto>("tournament Request dto bos..  bu mesaj degistirilebilir");
        }
        else{
            List<TournamentResponseDto> tournamentResponseDtoList = this.tournamentResponseMapper.mapTournamentListToTournamentResponseDtoList(tournamentList);
            return new SuccessDataResult<List<TournamentResponseDto>>(tournamentResponseDtoList);
        }
    }

    @Override
    public DataResult<TournamentResponseDto> createOneTournament(TournamentRequestDto newTournamentRequestDto) {
        //kontroller!
        if(newTournamentRequestDto == null){
            return new ErrorDataResult<TournamentResponseDto>("istek hatalı");
        }
        else{
            Tournament tournament = tournamentRequestMapper.mapTournamentRequestDtoToTournament(newTournamentRequestDto);
            tournament = this.tournamentDao.save(tournament);
            TournamentResponseDto tournamentResponseDto = tournamentResponseMapper.mapTournamentToTournamentResponseDto(tournament);
            return new SuccessDataResult<TournamentResponseDto>(tournamentResponseDto);
        }


    }

    @Override
    public DataResult<TournamentResponseDto> getOneTournementById(Long tournamentId) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            TournamentResponseDto tournamentResponseDto = tournamentResponseMapper.mapTournamentToTournamentResponseDto(tournament.get());
            return new SuccessDataResult<TournamentResponseDto>(tournamentResponseDto);
        }else{
            return new ErrorDataResult<TournamentResponseDto>("verilen id'ye ait turnuva bulunamadı..");
        }

    }

    @Override
    public DataResult<TournamentResponseDto> updateOneTournement(Long tournamentId, TournamentRequestDto tournamentRequestDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            Tournament toSave = tournament.get();
            toSave.setDescription(tournamentRequestDto.getDescription());
            toSave.setTournamentName(tournamentRequestDto.getTournamentName());
            toSave = this.tournamentDao.save(toSave);
            TournamentResponseDto newTournamentResponseDto = tournamentResponseMapper.mapTournamentToTournamentResponseDto(toSave);
            return new SuccessDataResult<TournamentResponseDto>(newTournamentResponseDto);
        }
        else{
            return new ErrorDataResult<TournamentResponseDto>("verilen id'ye ait turnuva bulunamadı..");
        }
    }

    @Override
    public Result deleteOneTournementById(Long tournamentId) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);

        if(tournament.isPresent()){
            this.tournamentDao.deleteById(tournament.get().getId());
            return new SuccessResult("id'si verilen turnuva silindi");
        }
        else{
            return new ErrorDataResult("silinmek istenen turnuva bulunamadi..");
        }
    }
}
