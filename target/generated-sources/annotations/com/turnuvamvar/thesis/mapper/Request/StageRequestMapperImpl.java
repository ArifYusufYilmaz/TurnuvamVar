package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.StageRequestDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T18:01:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StageRequestMapperImpl extends StageRequestMapper {

    @Override
    public StageRequestDto mapStageToStageRequestDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageRequestDto stageRequestDto = new StageRequestDto();

        stageRequestDto.setStageName( stage.getStageName() );
        stageRequestDto.setRequiredTeamCount( stage.getRequiredTeamCount() );

        return stageRequestDto;
    }

    @Override
    public Stage mapStageRequestDtoToStage(StageRequestDto stageRequestDto) {
        if ( stageRequestDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setStageName( stageRequestDto.getStageName() );
        stage.setRequiredTeamCount( stageRequestDto.getRequiredTeamCount() );

        return stage;
    }

    @Override
    public List<StageRequestDto> mapStageListToStageRequestDtoList(Collection<Stage> stageList) {
        if ( stageList == null ) {
            return null;
        }

        List<StageRequestDto> list = new ArrayList<StageRequestDto>( stageList.size() );
        for ( Stage stage : stageList ) {
            list.add( mapStageToStageRequestDto( stage ) );
        }

        return list;
    }

    @Override
    public List<Stage> mapStageRequestDtoListToStageList(Collection<StageRequestDto> stageRequestDtoList) {
        if ( stageRequestDtoList == null ) {
            return null;
        }

        List<Stage> list = new ArrayList<Stage>( stageRequestDtoList.size() );
        for ( StageRequestDto stageRequestDto : stageRequestDtoList ) {
            list.add( mapStageRequestDtoToStage( stageRequestDto ) );
        }

        return list;
    }
}
