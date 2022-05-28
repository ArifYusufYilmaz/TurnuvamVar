package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
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
public class StageResponseMapperImpl extends StageResponseMapper {

    @Override
    public StageResponseDto mapStageToStageResponseDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageResponseDto stageResponseDto = new StageResponseDto();

        stageResponseDto.setStageName( stage.getStageName() );

        return stageResponseDto;
    }

    @Override
    public Stage mapStageResponseDtoToStage(StageResponseDto stageResponseDto) {
        if ( stageResponseDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setStageName( stageResponseDto.getStageName() );

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
}
