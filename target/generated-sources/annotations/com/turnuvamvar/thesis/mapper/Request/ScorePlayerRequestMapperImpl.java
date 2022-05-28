package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T21:33:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ScorePlayerRequestMapperImpl extends ScorePlayerRequestMapper {

    @Override
    public ScorePlayer mapScorePlayerRequestDtoToScorePlayer(ScorePlayerRequestDto scorePlayerRequestDto) {
        if ( scorePlayerRequestDto == null ) {
            return null;
        }

        ScorePlayer scorePlayer = new ScorePlayer();

        return scorePlayer;
    }

    @Override
    public ScorePlayerResponseDto mapScorePlayerToScorePlayerRequestDto(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }

        ScorePlayerResponseDto scorePlayerResponseDto = new ScorePlayerResponseDto();

        return scorePlayerResponseDto;
    }
}
