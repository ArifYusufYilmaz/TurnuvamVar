package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageTeamResponseDto;
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
    date = "2022-05-29T01:31:15+0300",
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
        stageTeamResponseDto.setStageName( stageTeamStageStageName( stageTeam ) );
        stageTeamResponseDto.setTeamId( stageTeamTeamId( stageTeam ) );
        stageTeamResponseDto.setTeamName( stageTeamTeamTeamName( stageTeam ) );

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

    @Override
    public List<StageTeam> mapStageTeamResponseDtoListToStageTeamList(Collection<StageTeamResponseDto> stageTeamResponseDtoList) {
        if ( stageTeamResponseDtoList == null ) {
            return null;
        }

        List<StageTeam> list = new ArrayList<StageTeam>( stageTeamResponseDtoList.size() );
        for ( StageTeamResponseDto stageTeamResponseDto : stageTeamResponseDtoList ) {
            list.add( mapStageTeamResponseDtoToStageTeam( stageTeamResponseDto ) );
        }

        return list;
    }

    @Override
    public List<StageTeamResponseDto> mapStageTeamListToStageTeamResponseDtoList(Collection<StageTeam> stageTeamList) {
        if ( stageTeamList == null ) {
            return null;
        }

        List<StageTeamResponseDto> list = new ArrayList<StageTeamResponseDto>( stageTeamList.size() );
        for ( StageTeam stageTeam : stageTeamList ) {
            list.add( mapStageTeamToStageTeamResponseDto( stageTeam ) );
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

    private String stageTeamStageStageName(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }
        Stage stage = stageTeam.getStage();
        if ( stage == null ) {
            return null;
        }
        String stageName = stage.getStageName();
        if ( stageName == null ) {
            return null;
        }
        return stageName;
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

    private String stageTeamTeamTeamName(StageTeam stageTeam) {
        if ( stageTeam == null ) {
            return null;
        }
        Team team = stageTeam.getTeam();
        if ( team == null ) {
            return null;
        }
        String teamName = team.getTeamName();
        if ( teamName == null ) {
            return null;
        }
        return teamName;
    }

    protected Stage stageTeamResponseDtoToStage(StageTeamResponseDto stageTeamResponseDto) {
        if ( stageTeamResponseDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setId( stageTeamResponseDto.getStageId() );
        stage.setStageName( stageTeamResponseDto.getStageName() );

        return stage;
    }

    protected Team stageTeamResponseDtoToTeam(StageTeamResponseDto stageTeamResponseDto) {
        if ( stageTeamResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( stageTeamResponseDto.getTeamId() );
        team.setTeamName( stageTeamResponseDto.getTeamName() );

        return team;
    }
}
