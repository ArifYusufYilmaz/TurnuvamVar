package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T21:33:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StageTeamResponseMapperImpl extends StageTeamResponseMapper {

    @Override
    public StageTeamResponseDto mapStageTeamToStageTeamResponseDto(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }

        StageTeamResponseDto stageTeamResponseDto = new StageTeamResponseDto();

        stageTeamResponseDto.setStageId( stageTeamStageId( stageTeam ) );
        stageTeamResponseDto.setTeamId( stageTeamTeamId( stageTeam ) );

        return stageTeamResponseDto;
    }

    @Override
    public StageTeam mapStageTeamResponseDtoToStageTeam(StageTeamResponseDto stageTeamResponseDto) {
        if ( stageTeamResponseDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setStage( stageTeamResponseDtoToStage( stageTeamResponseDto ) );
        stageTeam.setTeam( stageTeamResponseDtoToTeam( stageTeamResponseDto ) );

        return stageTeam;
    }

    private Long stageTeamStageId(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }
        Stage stage = stageTeam.getStage();
        if ( stage == null ) {
            return null;
        }
        Long id = stage.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long stageTeamTeamId(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }
        Team team = stageTeam.getTeam();
        if ( team == null ) {
            return null;
        }
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Stage stageTeamResponseDtoToStage(StageTeamResponseDto stageTeamResponseDto) {
        if ( stageTeamResponseDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId( stageTeamResponseDto.getStageId() );

        return stage;
    }

    protected Team stageTeamResponseDtoToTeam(StageTeamResponseDto stageTeamResponseDto) {
        if ( stageTeamResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( stageTeamResponseDto.getTeamId() );

        return team;
    }
}
