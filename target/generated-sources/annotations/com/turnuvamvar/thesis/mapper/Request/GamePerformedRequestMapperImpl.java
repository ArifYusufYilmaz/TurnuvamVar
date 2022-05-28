package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.GamePerformedRequestDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T01:31:14+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GamePerformedRequestMapperImpl extends GamePerformedRequestMapper {

    @Override
    public GamePerformedRequestDto mapGamePerformedToGamePerformedRequestDto(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }

        GamePerformedRequestDto gamePerformedRequestDto = new GamePerformedRequestDto();

        gamePerformedRequestDto.setGameToPlayId( gamePerformedGameToPlayId( gamePerformed ) );
        gamePerformedRequestDto.setScoreOfFirstTeam( gamePerformedScoreOfFirstTeamScore( gamePerformed ) );
        gamePerformedRequestDto.setScoreOfSecondTeam( gamePerformedScoreOfSecondTeamScore( gamePerformed ) );

        return gamePerformedRequestDto;
    }

    @Override
    public GamePerformed mapGamePerformedRequestDtoToGamePerformed(GamePerformedRequestDto gamePerformedRequestDto) {
        if ( gamePerformedRequestDto == null ) {
            return null;
        }

        GamePerformed gamePerformed = new GamePerformed();

        gamePerformed.setGameToPlay( gamePerformedRequestDtoToGameToPlay( gamePerformedRequestDto ) );
        gamePerformed.setScoreOfFirstTeam( gamePerformedRequestDtoToScore( gamePerformedRequestDto ) );
        gamePerformed.setScoreOfSecondTeam( gamePerformedRequestDtoToScore1( gamePerformedRequestDto ) );

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

    protected GameToPlay gamePerformedRequestDtoToGameToPlay(GamePerformedRequestDto gamePerformedRequestDto) {
        if ( gamePerformedRequestDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setId( gamePerformedRequestDto.getGameToPlayId() );

        return gameToPlay;
    }

    protected Score gamePerformedRequestDtoToScore(GamePerformedRequestDto gamePerformedRequestDto) {
        if ( gamePerformedRequestDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedRequestDto.getScoreOfFirstTeam() );

        return score;
    }

    protected Score gamePerformedRequestDtoToScore1(GamePerformedRequestDto gamePerformedRequestDto) {
        if ( gamePerformedRequestDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedRequestDto.getScoreOfSecondTeam() );

        return score;
    }
}
