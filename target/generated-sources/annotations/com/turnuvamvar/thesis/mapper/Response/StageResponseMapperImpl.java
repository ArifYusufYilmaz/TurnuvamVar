package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.Tournament;
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
public class StageResponseMapperImpl extends StageResponseMapper {

    @Override
    public StageResponseDto mapStageToStageResponseDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageResponseDto stageResponseDto = new StageResponseDto();

        stageResponseDto.setTournamentId( stageTournamentId( stage ) );
        stageResponseDto.setTournamentName( stageTournamentTournamentName( stage ) );
        stageResponseDto.setId( stage.getId() );
        stageResponseDto.setStageName( stage.getStageName() );
        stageResponseDto.setRequiredTeamCount( stage.getRequiredTeamCount() );

        return stageResponseDto;
    }

    @Override
    public Stage mapStageResponseDtoToStage(StageResponseDto stageResponseDto) {
        if ( stageResponseDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setTournament( stageResponseDtoToTournament( stageResponseDto ) );
        stage.setId( stageResponseDto.getId() );
        stage.setStageName( stageResponseDto.getStageName() );
        stage.setRequiredTeamCount( stageResponseDto.getRequiredTeamCount() );

        return stage;
    }

    @Override
    public List<StageResponseDto> mapStageListToStageResponseDtoList(Collection<Stage> stageList) {
        if ( stageList == null ) {
            return null;
        }

        List<StageResponseDto> list = new ArrayList<StageResponseDto>( stageList.size() );
        for ( Stage stage : stageList ) {
            list.add( mapStageToStageResponseDto( stage ) );
        }

        return list;
    }

    @Override
    public List<Stage> mapStageResponseDtoListToStageList(Collection<StageResponseDto> stageResponseDtoList) {
        if ( stageResponseDtoList == null ) {
            return null;
        }

        List<Stage> list = new ArrayList<Stage>( stageResponseDtoList.size() );
        for ( StageResponseDto stageResponseDto : stageResponseDtoList ) {
            list.add( mapStageResponseDtoToStage( stageResponseDto ) );
        }

        return list;
    }

    private Long stageTournamentId(Stage stage) {
        if ( stage == null ) {
            return null;
        }
        Tournament tournament = stage.getTournament();
        if ( tournament == null ) {
            return null;
        }
        Long id = tournament.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String stageTournamentTournamentName(Stage stage) {
        if ( stage == null ) {
            return null;
        }
        Tournament tournament = stage.getTournament();
        if ( tournament == null ) {
            return null;
        }
        String tournamentName = tournament.getTournamentName();
        if ( tournamentName == null ) {
            return null;
        }
        return tournamentName;
    }

    protected Tournament stageResponseDtoToTournament(StageResponseDto stageResponseDto) {
        if ( stageResponseDto == null ) {
            return null;
        }

        Tournament tournament = new Tournament();

        tournament.setId( stageResponseDto.getTournamentId() );
        tournament.setTournamentName( stageResponseDto.getTournamentName() );

        return tournament;
    }
}
