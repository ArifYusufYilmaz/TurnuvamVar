package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import javax.annotation.Generated;

import com.turnuvamvar.thesis.mapper.Response.GamePerformedResponseMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T18:45:34+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GamePerformedResponseMapperImpl extends GamePerformedResponseMapper {

    @Override
    public GamePerformedResponseDto mapGamePerformedToGamePerformedResponseDto(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }

        GamePerformedResponseDto gamePerformedResponseDto = new GamePerformedResponseDto();

        gamePerformedResponseDto.setGameToPlayId( gamePerformedGameToPlayId( gamePerformed ) );
        gamePerformedResponseDto.setScoreOfFirstTeam( gamePerformedScoreOfFirstTeamScore( gamePerformed ) );
        gamePerformedResponseDto.setScoreOfSecondTeam( gamePerformedScoreOfSecondTeamScore( gamePerformed ) );

        return gamePerformedResponseDto;
    }

    @Override
    public GamePerformed mapGamePerformedDtoToGamePerformed(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        GamePerformed gamePerformed = new GamePerformed();

        gamePerformed.setGameToPlay( gamePerformedDtoToGameToPlay(gamePerformedResponseDto) );
        gamePerformed.setScoreOfFirstTeam( gamePerformedDtoToScore(gamePerformedResponseDto) );
        gamePerformed.setScoreOfSecondTeam( gamePerformedDtoToScore1(gamePerformedResponseDto) );

        return gamePerformed;
    }

    private Long gamePerformedGameToPlayId(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }
        GameToPlay gameToPlay = gamePerformed.getGameToPlay();
        if ( gameToPlay == null ) {
            return null;
        }
        Long id = gameToPlay.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private int gamePerformedScoreOfFirstTeamScore(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return 0;
        }
        Score scoreOfFirstTeam = gamePerformed.getScoreOfFirstTeam();
        if ( scoreOfFirstTeam == null ) {
            return 0;
        }
        int score = scoreOfFirstTeam.getScore();
        return score;
    }

    private int gamePerformedScoreOfSecondTeamScore(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return 0;
        }
        Score scoreOfSecondTeam = gamePerformed.getScoreOfSecondTeam();
        if ( scoreOfSecondTeam == null ) {
            return 0;
        }
        int score = scoreOfSecondTeam.getScore();
        return score;
    }

    protected GameToPlay gamePerformedDtoToGameToPlay(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setId( gamePerformedResponseDto.getGameToPlayId() );

        return gameToPlay;
    }

    protected Score gamePerformedDtoToScore(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedResponseDto.getScoreOfFirstTeam() );

        return score;
    }

    protected Score gamePerformedDtoToScore1(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedResponseDto.getScoreOfSecondTeam() );

        return score;
    }
}
