package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T18:07:44+0300",
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
        gamePerformedResponseDto.setFirstTeamId( gamePerformedGameToPlayStageTeamFirstTeamId( gamePerformed ) );
        gamePerformedResponseDto.setFirstTeamName( gamePerformedGameToPlayStageTeamFirstTeamTeamName( gamePerformed ) );
        gamePerformedResponseDto.setSecondTeamId( gamePerformedGameToPlayStageTeamSecondTeamId( gamePerformed ) );
        gamePerformedResponseDto.setSecondTeamName( gamePerformedGameToPlayStageTeamSecondTeamTeamName( gamePerformed ) );
        gamePerformedResponseDto.setId( gamePerformed.getId() );

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
        gamePerformed.setId( gamePerformedResponseDto.getId() );

        return gamePerformed;
    }

    @Override
    public List<GamePerformed> mapGamePerformedResponseDtoListToGamePerformedList(Collection<GamePerformedResponseDto> gamePerformedResponseDtoList) {
        if ( gamePerformedResponseDtoList == null ) {
            return null;
        }

        List<GamePerformed> list = new ArrayList<GamePerformed>( gamePerformedResponseDtoList.size() );
        for ( GamePerformedResponseDto gamePerformedResponseDto : gamePerformedResponseDtoList ) {
            list.add( mapGamePerformedResponseDtoToGamePerformed( gamePerformedResponseDto ) );
        }

        return list;
    }

    @Override
    public List<GamePerformedResponseDto> mapGamePerformedListToGamePerformedResponseList(Collection<GamePerformed> gamePerformedList) {
        if ( gamePerformedList == null ) {
            return null;
        }

        List<GamePerformedResponseDto> list = new ArrayList<GamePerformedResponseDto>( gamePerformedList.size() );
        for ( GamePerformed gamePerformed : gamePerformedList ) {
            list.add( mapGamePerformedToGamePerformedResponseDto( gamePerformed ) );
        }

        return list;
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

    private Long gamePerformedGameToPlayStageTeamFirstTeamId(GamePerformed gamePerformed) {
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
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    private Long gamePerformedGameToPlayStageTeamSecondTeamId(GamePerformed gamePerformed) {
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
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    protected Team gamePerformedResponseDtoToTeam(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gamePerformedResponseDto.getFirstTeamId() );
        team.setTeamName( gamePerformedResponseDto.getFirstTeamName() );

        return team;
    }

    protected StageTeam gamePerformedResponseDtoToStageTeam(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setTeam( gamePerformedResponseDtoToTeam( gamePerformedResponseDto ) );

        return stageTeam;
    }

    protected Team gamePerformedResponseDtoToTeam1(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( gamePerformedResponseDto.getSecondTeamId() );
        team.setTeamName( gamePerformedResponseDto.getSecondTeamName() );

        return team;
    }

    protected StageTeam gamePerformedResponseDtoToStageTeam1(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setTeam( gamePerformedResponseDtoToTeam1( gamePerformedResponseDto ) );

        return stageTeam;
    }

    protected GameToPlay gamePerformedResponseDtoToGameToPlay(GamePerformedResponseDto gamePerformedResponseDto) {
        if ( gamePerformedResponseDto == null ) {
            return null;
        }

        GameToPlay gameToPlay = new GameToPlay();

        gameToPlay.setStageTeamFirst( gamePerformedResponseDtoToStageTeam( gamePerformedResponseDto ) );
        gameToPlay.setStageTeamSecond( gamePerformedResponseDtoToStageTeam1( gamePerformedResponseDto ) );
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
