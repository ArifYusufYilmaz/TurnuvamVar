package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

import com.turnuvamvar.thesis.mapper.Response.GameToPlayResponseMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T20:59:36+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GameToPlayResponseMapperImpl extends GameToPlayResponseMapper {

    @Override
    public GameToPlayResponseDto mapGameToPlayToGameToPlayResponseDto(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }

        GameToPlayResponseDto gameToPlayResponseDto = new GameToPlayResponseDto();

        gameToPlayResponseDto.setFirstTeamId( gameToPlayStageTeamFirstId( gameToPlay ) );
        gameToPlayResponseDto.setSecondTeamId( gameToPlayStageTeamSecondId( gameToPlay ) );
        gameToPlayResponseDto.setTarih( gameToPlay.getTarih() );

        return gameToPlayResponseDto;
    }

    @Override
    public GameToPlay mapGameToPlayResponseDtoToGameToPlay(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setStageTeamFirst( gameToPlayResponseDtoToStageTeam( gameToPlayResponseDto ) );
        gameToPlay.setStageTeamSecond( gameToPlayResponseDtoToStageTeam1( gameToPlayResponseDto ) );
        gameToPlay.setTarih( gameToPlayResponseDto.getTarih() );

        return gameToPlay;
    }

    @Override
    public List<GameToPlayResponseDto> mapGameToPlayToListGameToPlayResponseDtoList(Collection<GameToPlay> gamesToPlay) {
        if ( gamesToPlay == null ) {
            return null;
        }

        List<GameToPlayResponseDto> list = new ArrayList<GameToPlayResponseDto>( gamesToPlay.size() );
        for ( GameToPlay gameToPlay : gamesToPlay ) {
            list.add( mapGameToPlayToGameToPlayResponseDto( gameToPlay ) );
        }

        return list;
    }

    @Override
    public List<GameToPlay> mapGameToPlayResponseDtoListToGameToPlayList(Collection<GameToPlayResponseDto> gamesToPlayDto) {
        if ( gamesToPlayDto == null ) {
            return null;
        }

        List<GameToPlay> list = new ArrayList<GameToPlay>( gamesToPlayDto.size() );
        for ( GameToPlayResponseDto gameToPlayResponseDto : gamesToPlayDto ) {
            list.add( mapGameToPlayResponseDtoToGameToPlay( gameToPlayResponseDto ) );
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

    protected StageTeam gameToPlayResponseDtoToStageTeam(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayResponseDto.getFirstTeamId() );

        return stageTeam;
    }

    protected StageTeam gameToPlayResponseDtoToStageTeam1(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayResponseDto.getSecondTeamId() );

        return stageTeam;
    }
}
