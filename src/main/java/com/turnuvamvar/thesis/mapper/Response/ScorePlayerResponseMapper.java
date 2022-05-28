package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ScorePlayerResponseMapper {
    @Mapping(source="scoreId",target="score.id")
    @Mapping(source="playerId",target="player.id")
    public abstract ScorePlayer mapScorePlayerResponseDtoToScorePlayer(ScorePlayerResponseDto scorePlayerResponseDto);
    @Mapping(source="score.id",target="scoreId")
    @Mapping(source="player.id",target="playerId")
    public abstract ScorePlayerResponseDto mapScorePlayerToScorePlayerResponseDto(ScorePlayer scorePlayer);
}
