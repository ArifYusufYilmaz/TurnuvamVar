package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.TournamentService;
import com.turnuvamvar.thesis.core.utilities.results.*;
import com.turnuvamvar.thesis.dataAccess.abstracts.TournamentDao;
import com.turnuvamvar.thesis.dto.TournamentDto;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
import com.turnuvamvar.thesis.mapper.TournamentMapper;
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
        List<Tournament> tournamentList = new ArrayList<>();
        Iterable<Tournament> tournamentIterable = this.tournamentDao.findAll();
        tournamentIterable.iterator().forEachRemaining(tournamentList :: add);
        List<TournamentDto> tournamentDtoList = this.tournamentMapper.mapTournamentListToTournamentDtoList(tournamentList);
        if(tournamentDtoList.isEmpty()){
            return new ErrorDataResult<>("tournament dto bos..  bu mesaj degistirilebilir");
        }

        return new SuccessDataResult<List<TournamentDto>>(tournamentDtoList);
    }

    @Override
    public DataResult<TournamentDto> createOneTournament(TournamentDto newTournamentDto) {
        //kontroller!
            Tournament tournament = tournamentMapper.mapTournamentDtoToTournament(newTournamentDto);
            TournamentDto tournamentDto = tournamentMapper.mapTournamentToTournamentDto(this.tournamentDao.save(tournament));
            return new SuccessDataResult<TournamentDto>(tournamentDto);

    }

    @Override
    public DataResult<Tournament> getOneTournementById(Long tournamentId) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            return new SuccessDataResult<Tournament>(tournament.get());
        }else{
            return new ErrorDataResult<>("verilen id'ye ait turnuva bulunamadı..");
        }

    }

    @Override
    public DataResult<TournamentDto> updateOneTournement(Long tournamentId, TournamentDto tournamentDto) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        if(tournament.isPresent()){
            Tournament toSave = tournament.get();
            toSave.setDescription(tournamentDto.getDescription());
            toSave.setTournamentName(tournamentDto.getTournamentName());
            toSave = this.tournamentDao.save(toSave);
            TournamentDto newTournamentDto = tournamentMapper.mapTournamentToTournamentDto(toSave);
            return new SuccessDataResult<TournamentDto>(newTournamentDto);
        }
        else{
            return new ErrorDataResult<>("verilen id'ye ait turnuva bulunamadı..");
        }
    }

    @Override
    public Result deleteOneTournementById(Long tournamentId) {
        Optional<Tournament> tournament = this.tournamentDao.findById(tournamentId);
        System.out.println("silmek için girdim");
        if(tournament.isPresent()){
            this.tournamentDao.deleteById(tournament.get().getId());
            return new SuccessResult("id'si verilen turnuva silindi");
        }
        else{
            return new ErrorDataResult("silinmek istenen turnuva bulunamadi..");
        }
    }
}
