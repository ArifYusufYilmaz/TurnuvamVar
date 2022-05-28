package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T01:31:15+0300",
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
        gamePerformedResponseDto.setFirstTeamName( gamePerformedGameToPlayStageTeamFirstTeamTeamName( gamePerformed ) );
        gamePerformedResponseDto.setSecondTeamName( gamePerformedGameToPlayStageTeamSecondTeamTeamName( gamePerformed ) );

        return gamePerformedResponseDto;
    }

    @Override
    public GamePerformed mapGamePerformedResponseDtoToGamePerformed(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        GamePerformed gamePerformed = new GamePerformed();

        gamePerformed.setGameToPlay( gamePerformedResponseDtoToGameToPlay( gamePerformedResponseDto ) );
        gamePerformed.setScoreOfFirstTeam( gamePerformedResponseDtoToScore( gamePerformedResponseDto ) );
        gamePerformed.setScoreOfSecondTeam( gamePerformedResponseDtoToScore1( gamePerformedResponseDto ) );

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

    private String gamePerformedGameToPlayStageTeamFirstTeamTeamName(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }
        GameToPlay gameToPlay = gamePerformed.getGameToPlay();
        if ( gameToPlay == null ) {
            return null;
        }
        StageTeam stageTeamFirst = gameToPlay.getStageTeamFirst();
        if ( stageTeamFirst == null ) {
            return null;
        }
        Team team = stageTeamFirst.getTeam();
        if ( team == null ) {
            return null;
        }
        String teamName = team.getTeamName();
        if ( teamName == null ) {
            return null;
        }
        return teamName;
    }

    private String gamePerformedGameToPlayStageTeamSecondTeamTeamName(GamePerformed gamePerformed) {
        if ( gamePerformed == null ) {
            return null;
        }
        GameToPlay gameToPlay = gamePerformed.getGameToPlay();
        if ( gameToPlay == null ) {
            return null;
        }
        StageTeam stageTeamSecond = gameToPlay.getStageTeamSecond();
        if ( stageTeamSecond == null ) {
            return null;
        }
        Team team = stageTeamSecond.getTeam();
        if ( team == null ) {
            return null;
        }
        String teamName = team.getTeamName();
        if ( teamName == null ) {
            return null;
        }
        return teamName;
    }

    protected GameToPlay gamePerformedResponseDtoToGameToPlay(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setId( gamePerformedResponseDto.getGameToPlayId() );

        return gameToPlay;
    }

    protected Score gamePerformedResponseDtoToScore(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedResponseDto.getScoreOfFirstTeam() );

        return score;
    }

    protected Score gamePerformedResponseDtoToScore1(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setScore( gamePerformedResponseDto.getScoreOfSecondTeam() );

        return score;
    }
}
