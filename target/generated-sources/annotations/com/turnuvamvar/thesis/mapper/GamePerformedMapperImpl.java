package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T01:13:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GamePerformedMapperImpl extends GamePerformedMapper {

    @Override
    public GamePerformedDto mapGamePerformedToGamePerformedDto(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }

        GamePerformedDto gamePerformedDto = new GamePerformedDto();

        gamePerformedDto.setGameToPlayId( gamePerformedGameToPlayId( gamePerformed ) );
        gamePerformedDto.setScoreOfFirstTeam( gamePerformedScoreOfFirstTeamCountOfScore( gamePerformed ) );
        gamePerformedDto.setScoreOfSecondTeam( gamePerformedScoreOfSecondTeamCountOfScore( gamePerformed ) );

        return gamePerformedDto;
    }

    @Override
    public GamePerformed mapGamePerformedDtoToGamePerformed(GamePerformedDto gamePerformedDto) {
        if ( gamePerformedDto == null ) {
            return null;
        }

        GamePerformed gamePerformed = new GamePerformed();

        gamePerformed.setGameToPlay( gamePerformedDtoToGameToPlay( gamePerformedDto ) );
        gamePerformed.setScoreOfFirstTeam( gamePerformedDtoToScore( gamePerformedDto ) );
        gamePerformed.setScoreOfSecondTeam( gamePerformedDtoToScore1( gamePerformedDto ) );

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

    private int gamePerformedScoreOfFirstTeamCountOfScore(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return 0;
        }
        Score scoreOfFirstTeam = gamePerformed.getScoreOfFirstTeam();
        if ( scoreOfFirstTeam == null ) {
            return 0;
        }
        int countOfScore = scoreOfFirstTeam.getCountOfScore();
        return countOfScore;
    }

    private int gamePerformedScoreOfSecondTeamCountOfScore(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return 0;
        }
        Score scoreOfSecondTeam = gamePerformed.getScoreOfSecondTeam();
        if ( scoreOfSecondTeam == null ) {
            return 0;
        }
        int countOfScore = scoreOfSecondTeam.getCountOfScore();
        return countOfScore;
    }

    protected GameToPlay gamePerformedDtoToGameToPlay(GamePerformedDto gamePerformedDto) {
        if ( gamePerformedDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setId( gamePerformedDto.getGameToPlayId() );

        return gameToPlay;
    }

    protected Score gamePerformedDtoToScore(GamePerformedDto gamePerformedDto) {
        if ( gamePerformedDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setCountOfScore( gamePerformedDto.getScoreOfFirstTeam() );

        return score;
    }

    protected Score gamePerformedDtoToScore1(GamePerformedDto gamePerformedDto) {
        if ( gamePerformedDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setCountOfScore( gamePerformedDto.getScoreOfSecondTeam() );

        return score;
    }
}
