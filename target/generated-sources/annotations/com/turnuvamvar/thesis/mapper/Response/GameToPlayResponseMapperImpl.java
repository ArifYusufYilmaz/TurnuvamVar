package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-05T02:59:56+0300",
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

        gameToPlayResponseDto.setFirstStageTeamId( gameToPlayStageTeamFirstId( gameToPlay ) );
        gameToPlayResponseDto.setFirstTeamName( gameToPlayStageTeamFirstTeamTeamName( gameToPlay ) );
        gameToPlayResponseDto.setSecondStageTeamId( gameToPlayStageTeamSecondId( gameToPlay ) );
        gameToPlayResponseDto.setSecondTeamName( gameToPlayStageTeamSecondTeamTeamName( gameToPlay ) );
        gameToPlayResponseDto.setStageId( gameToPlayStageTeamFirstStageId( gameToPlay ) );
        gameToPlayResponseDto.setId( gameToPlay.getId() );
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
        gameToPlay.setId( gameToPlayResponseDto.getId() );
        gameToPlay.setTarih( gameToPlayResponseDto.getTarih() );

        return gameToPlay;
    }

    @Override
    public List<GameToPlayResponseDto> mapGameToPlayListToGameToPlayResponseDtoList(Collection<GameToPlay> gamesToPlay) {
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

    private String gameToPlayStageTeamFirstTeamTeamName(GameToPlay gameToPlay) {
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

    private String gameToPlayStageTeamSecondTeamTeamName(GameToPlay gameToPlay) {
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

    private Long gameToPlayStageTeamFirstStageId(GameToPlay gameToPlay) {
        if ( gameToPlay == null ) {
            return null;
        }
        StageTeam stageTeamFirst = gameToPlay.getStageTeamFirst();
        if ( stageTeamFirst == null ) {
            return null;
        }
        Stage stage = stageTeamFirst.getStage();
        if ( stage == null ) {
            return null;
        }
        Long id = stage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Team gameToPlayResponseDtoToTeam(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( gameToPlayResponseDto.getFirstTeamName() );

        return team;
    }

    protected Stage gameToPlayResponseDtoToStage(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId( gameToPlayResponseDto.getStageId() );

        return stage;
    }

    protected StageTeam gameToPlayResponseDtoToStageTeam(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setTeam( gameToPlayResponseDtoToTeam( gameToPlayResponseDto ) );
        stageTeam.setStage( gameToPlayResponseDtoToStage( gameToPlayResponseDto ) );
        stageTeam.setId( gameToPlayResponseDto.getFirstStageTeamId() );

        return stageTeam;
    }

    protected Team gameToPlayResponseDtoToTeam1(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setTeamName( gameToPlayResponseDto.getSecondTeamName() );

        return team;
    }

    protected StageTeam gameToPlayResponseDtoToStageTeam1(GameToPlayResponseDto gameToPlayResponseDto) {
        if ( gameToPlayResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setTeam( gameToPlayResponseDtoToTeam1( gameToPlayResponseDto ) );
        stageTeam.setId( gameToPlayResponseDto.getSecondStageTeamId() );

        return stageTeam;
    }
}
