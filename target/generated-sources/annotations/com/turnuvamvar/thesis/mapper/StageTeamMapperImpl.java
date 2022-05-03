package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.entities.concretes.Team;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T19:25:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StageTeamMapperImpl extends StageTeamMapper {

    @Override
    public StageTeamDto mapStageTeamToStageTeamDto(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }

        StageTeamDto stageTeamDto = new StageTeamDto();

        stageTeamDto.setStageId( stageTeamStageId( stageTeam ) );
        stageTeamDto.setTeamId( stageTeamTeamId( stageTeam ) );

        return stageTeamDto;
    }

    @Override
    public StageTeam mapStageTeamDtoToStage(StageTeamDto stageTeamDto) {
        if ( stageTeamDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setStage( stageTeamDtoToStage( stageTeamDto ) );
        stageTeam.setTeam( stageTeamDtoToTeam( stageTeamDto ) );

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

    protected Stage stageTeamDtoToStage(StageTeamDto stageTeamDto) {
        if ( stageTeamDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId( stageTeamDto.getStageId() );

        return stage;
    }

    protected Team stageTeamDtoToTeam(StageTeamDto stageTeamDto) {
        if ( stageTeamDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( stageTeamDto.getTeamId() );

        return team;
    }
}
