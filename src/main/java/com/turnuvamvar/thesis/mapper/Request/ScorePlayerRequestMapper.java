package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScorePlayerRequestMapper {
    @Mapping(source="scoreId",target="score.id")
    @Mapping(source="playerId",target="player.id")
    public abstract ScorePlayer mapScorePlayerRequestDtoToScorePlayer(ScorePlayerRequestDto scorePlayerRequestDto);
    @Mapping(source="score.id",target="scoreId")
    @Mapping(source="player.id",target="playerId")
    public abstract ScorePlayerRequestDto mapScorePlayerToScorePlayerRequestDto(ScorePlayer scorePlayer);
    public abstract List<ScorePlayer> mapScorePLayerRequestDtoListToScorePlayerList(Collection<ScorePlayerRequestDto> scorePlayerRequestDtoList);
    public abstract List<ScorePlayerRequestDto> mapScorePlayerListToScorePlayerRequestDtoList(Collection<ScorePlayer> scorePLayer);
}
