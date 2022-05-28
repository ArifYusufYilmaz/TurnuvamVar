package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ScorePlayerRequestMapper {

    public abstract ScorePlayer mapScorePlayerRequestDtoToScorePlayer(ScorePlayerRequestDto scorePlayerRequestDto);
    public abstract ScorePlayerResponseDto mapScorePlayerToScorePlayerRequestDto(ScorePlayer scorePlayer);
}
