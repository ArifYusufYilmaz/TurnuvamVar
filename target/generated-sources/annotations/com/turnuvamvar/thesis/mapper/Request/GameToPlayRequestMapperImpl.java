package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.GameToPlayRequestDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T19:32:57+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GameToPlayRequestMapperImpl extends GameToPlayRequestMapper {

    @Override
    public GameToPlayRequestDto mapGameToPlayToGameToPlayRequestDto(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }

        GameToPlayRequestDto gameToPlayRequestDto = new GameToPlayRequestDto();

        gameToPlayRequestDto.setFirstStageTeamId( gameToPlayStageTeamFirstId( gameToPlay ) );
        gameToPlayRequestDto.setSecondStageTeamId( gameToPlayStageTeamSecondId( gameToPlay ) );
        gameToPlayRequestDto.setTarih( gameToPlay.getTarih() );

        return gameToPlayRequestDto;
    }

    @Override
    public GameToPlay mapGameToPlayRequestDtoToGameToPlay(GameToPlayRequestDto gameToPlayRequestDto) {
        if ( gameToPlayRequestDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setStageTeamFirst( gameToPlayRequestDtoToStageTeam( gameToPlayRequestDto ) );
        gameToPlay.setStageTeamSecond( gameToPlayRequestDtoToStageTeam1( gameToPlayRequestDto ) );
        gameToPlay.setTarih( gameToPlayRequestDto.getTarih() );

        return gameToPlay;
    }

    @Override
    public List<GameToPlayRequestDto> mapGameToPlayListToGameToPlayRequestDtoList(Collection<GameToPlay> gamesToPlay) {
        if ( gamesToPlay == null ) {
            return null;
        }

        List<GameToPlayRequestDto> list = new ArrayList<GameToPlayRequestDto>( gamesToPlay.size() );
        for ( GameToPlay gameToPlay : gamesToPlay ) {
            list.add( mapGameToPlayToGameToPlayRequestDto( gameToPlay ) );
        }

        return list;
    }

    @Override
    public List<GameToPlay> mapGameToPlayRequestDtoListToGameToPlayList(Collection<GameToPlayRequestDto> gamesToPlayDto) {
        if ( gamesToPlayDto == null ) {
            return null;
        }

        List<GameToPlay> list = new ArrayList<GameToPlay>( gamesToPlayDto.size() );
        for ( GameToPlayRequestDto gameToPlayRequestDto : gamesToPlayDto ) {
            list.add( mapGameToPlayRequestDtoToGameToPlay( gameToPlayRequestDto ) );
        }

        return list;
    }

    private Long gameToPlayStageTeamFirstId(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }
        StageTeam stageTeamFirst = gameToPlay.getStageTeamFirst();
        if ( stageTeamFirst == null ) {
            return null;
        }
        Long id = stageTeamFirst.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long gameToPlayStageTeamSecondId(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }
        StageTeam stageTeamSecond = gameToPlay.getStageTeamSecond();
        if ( stageTeamSecond == null ) {
            return null;
        }
        Long id = stageTeamSecond.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected StageTeam gameToPlayRequestDtoToStageTeam(GameToPlayRequestDto gameToPlayRequestDto) {
        if ( gameToPlayRequestDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayRequestDto.getFirstStageTeamId() );

        return stageTeam;
    }

    protected StageTeam gameToPlayRequestDtoToStageTeam1(GameToPlayRequestDto gameToPlayRequestDto) {
        if ( gameToPlayRequestDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayRequestDto.getSecondStageTeamId() );

        return stageTeam;
    }
}
