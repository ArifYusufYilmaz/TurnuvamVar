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
    public DataResult<List<TournamentRequestDto>> getAllTournaments() {
        List<Tournament> tournamentList = new ArrayList<>();
        Iterable<Tournament> tournamentIterable = this.tournamentDao.findAll();
        tournamentIterable.iterator().forEachRemaining(tournamentList :: add);
        List<TournamentRequestDto> tournamentRequestDtoList = this.tournamentRequestMapper.mapTournamentListToTournamentRequestDtoList(tournamentList);
        if(tournamentRequestDtoList.isEmpty()){
            return new ErrorDataResult<TournamentRequestDto>("tournament Request dto bos..  bu mesaj degistirilebilir");
        }

        return new SuccessDataResult<List<TournamentRequestDto>>(tournamentRequestDtoList);
    }

    @Override
    public DataResult<TournamentResponseDto> createOneTournament(TournamentResponseDto newTournamentResponseDto) {
        //kontroller!
            Tournament tournament = tournamentResponseMapper.mapTournamentResponseDtoToTournament(newTournamentResponseDto);
            TournamentResponseDto tournamentResponseDto = tournamentResponseMapper.mapTournamentToTournamentResponseDto(this.tournamentDao.save(tournament));
            return new SuccessDataResult<TournamentResponseDto>(tournamentResponseDto);

    }

    @Override
    public DataResult<TournamentRequestDto> getOneTournementById(Long tournamentId) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            TournamentRequestDto tournamentRequestDto = tournamentRequestMapper.mapTournamentToTournamentRequestDto(tournament.get());
            return new SuccessDataResult<TournamentRequestDto>(tournamentRequestDto);
        }else{
            return new ErrorDataResult<TournamentRequestDto>("verilen id'ye ait turnuva bulunamadı..");
        }

    }

    @Override
    public DataResult<TournamentResponseDto> updateOneTournement(Long tournamentId, TournamentResponseDto tournamentResponseDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            Tournament toSave = tournament.get();
            toSave.setDescription(tournamentResponseDto.getDescription());
            toSave.setTournamentName(tournamentResponseDto.getTournamentName());
            toSave = this.tournamentDao.save(toSave);
            TournamentResponseDto newTournamentResponseDto = tournamentResponseMapper.mapTournamentToTournamentResponseDto(toSave);
            return new SuccessDataResult<TournamentResponseDto>(newTournamentResponseDto);
        }
        else{
            return new ErrorDataResult<>("verilen id'ye ait turnuva bulunamadı..");
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
