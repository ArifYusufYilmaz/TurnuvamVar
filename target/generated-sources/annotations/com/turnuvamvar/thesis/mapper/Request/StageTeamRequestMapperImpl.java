package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.StageTeamRequestDto;
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
    date = "2022-05-28T01:40:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StageTeamRequestMapperImpl extends StageTeamRequestMapper {

    @Override
    public StageTeamRequestDto mapStageTeamToStageTeamRequestDto(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }

        StageTeamRequestDto stageTeamRequestDto = new StageTeamRequestDto();

        stageTeamRequestDto.setStageId( stageTeamStageId( stageTeam ) );
        stageTeamRequestDto.setTeamId( stageTeamTeamId( stageTeam ) );

        return stageTeamRequestDto;
    }

    @Override
    public StageTeam mapStageTeamRequestDtoToStage(StageTeamRequestDto stageTeamRequestDto) {
        if ( stageTeamRequestDto == null ) {
            return null;
        }

        StageTeam stageTeam = new StageTeam();

        stageTeam.setStage( stageTeamRequestDtoToStage( stageTeamRequestDto ) );
        stageTeam.setTeam( stageTeamRequestDtoToTeam( stageTeamRequestDto ) );

        return stageTeam;
    }

    @Override
    public List<StageTeam> mapStageTeamRequestDtoListToStageTeamList(Collection<StageTeamRequestDto> stageTeamRequestDtoList) {
        if ( stageTeamRequestDtoList == null ) {
            return null;
        }

        List<StageTeam> list = new ArrayList<StageTeam>( stageTeamRequestDtoList.size() );
        for ( StageTeamRequestDto stageTeamRequestDto : stageTeamRequestDtoList ) {
            list.add( mapStageTeamRequestDtoToStage( stageTeamRequestDto ) );
        }

        return list;
    }

    @Override
    public List<StageTeamRequestDto> mapStageTeamListToStageTeamRequestDtoList(Collection<StageTeam> stageTeamList) {
        if ( stageTeamList == null ) {
            return null;
        }

        List<StageTeamRequestDto> list = new ArrayList<StageTeamRequestDto>( stageTeamList.size() );
        for ( StageTeam stageTeam : stageTeamList ) {
            list.add( mapStageTeamToStageTeamRequestDto( stageTeam ) );
        }

        return list;
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

    protected Stage stageTeamRequestDtoToStage(StageTeamRequestDto stageTeamRequestDto) {
        if ( stageTeamRequestDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId( stageTeamRequestDto.getStageId() );

        return stage;
    }

    protected Team stageTeamRequestDtoToTeam(StageTeamRequestDto stageTeamRequestDto) {
        if ( stageTeamRequestDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( stageTeamRequestDto.getTeamId() );

        return team;
    }
}
