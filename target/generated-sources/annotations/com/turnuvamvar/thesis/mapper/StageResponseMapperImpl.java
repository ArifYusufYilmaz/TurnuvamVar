package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.Response.StageResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import javax.annotation.Generated;

import com.turnuvamvar.thesis.mapper.Response.StageResponseMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T20:54:58+0300",
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
}
