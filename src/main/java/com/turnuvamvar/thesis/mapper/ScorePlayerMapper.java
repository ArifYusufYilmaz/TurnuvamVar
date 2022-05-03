package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ScorePlayerMapper {
    @Mapping(source="scoreId",target="score.id")
    @Mapping(source="playerId",target="player.id")
    public abstract ScorePlayer mapScorePlayerDtoToScorePlayer(ScorePlayerDto scorePlayerDto);
    @Mapping(source="score.id",target="scoreId")
    @Mapping(source="player.id",target="playerId")
    public abstract ScorePlayerDto mapScorePlayerToScorePlayerDto(ScorePlayer scorePlayer);
}
