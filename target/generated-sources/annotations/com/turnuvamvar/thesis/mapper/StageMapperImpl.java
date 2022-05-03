package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.StageDto;
import com.turnuvamvar.thesis.entities.concretes.Stage;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T18:36:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StageMapperImpl extends StageMapper {

    @Override
    public StageDto mapStageToStageDto(Stage stage) {
        if ( stage == null ) {
            return null;
        }

        StageDto stageDto = new StageDto();

        stageDto.setStageName( stage.getStageName() );

        return stageDto;
    }

    @Override
    public Stage mapStageDtoToStage(StageDto stageDto) {
        if ( stageDto == null ) {
            return null;
        }

        Stage stage = new Stage();

        stage.setStageName( stageDto.getStageName() );

        return stage;
    }
}
