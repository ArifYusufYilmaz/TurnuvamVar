package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T19:06:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GameToPlayMapperImpl extends GameToPlayMapper {

    @Override
    public GameToPlayDto mapGameToPlayToGameToPlayDto(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }

        GameToPlayDto gameToPlayDto = new GameToPlayDto();

        gameToPlayDto.setFirstTeamId( gameToPlayStageTeamFirstId( gameToPlay ) );
        gameToPlayDto.setSecondTeamId( gameToPlayStageTeamSecondId( gameToPlay ) );
        gameToPlayDto.setTarih( gameToPlay.getTarih() );

        return gameToPlayDto;
    }

    @Override
    public GameToPlay mapGameToPlayDtoToGameToPlay(GameToPlayDto gameToPlayDto) {
        if ( gameToPlayDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setStageTeamFirst( gameToPlayDtoToStageTeam( gameToPlayDto ) );
        gameToPlay.setStageTeamSecond( gameToPlayDtoToStageTeam1( gameToPlayDto ) );
        gameToPlay.setTarih( gameToPlayDto.getTarih() );

        return gameToPlay;
    }

    @Override
    public List<GameToPlayDto> mapGameToPlayToListGameToPlayDtoList(Collection<GameToPlay> gamesToPlay) {
        if ( gamesToPlay == null ) {
            return null;
        }

        List<GameToPlayDto> list = new ArrayList<GameToPlayDto>( gamesToPlay.size() );
        for ( GameToPlay gameToPlay : gamesToPlay ) {
            list.add( mapGameToPlayToGameToPlayDto( gameToPlay ) );
        }

        return list;
    }

    @Override
    public List<GameToPlay> mapGameToPlayDtoListToGameToPlayList(Collection<GameToPlayDto> gamesToPlayDto) {
        if ( gamesToPlayDto == null ) {
            return null;
        }

        List<GameToPlay> list = new ArrayList<GameToPlay>( gamesToPlayDto.size() );
        for ( GameToPlayDto gameToPlayDto : gamesToPlayDto ) {
            list.add( mapGameToPlayDtoToGameToPlay( gameToPlayDto ) );
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

    protected StageTeam gameToPlayDtoToStageTeam(GameToPlayDto gameToPlayDto) {
        if ( gameToPlayDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayDto.getFirstTeamId() );

        return stageTeam;
    }

    protected StageTeam gameToPlayDtoToStageTeam1(GameToPlayDto gameToPlayDto) {
        if ( gameToPlayDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setId( gameToPlayDto.getSecondTeamId() );

        return stageTeam;
    }
}
