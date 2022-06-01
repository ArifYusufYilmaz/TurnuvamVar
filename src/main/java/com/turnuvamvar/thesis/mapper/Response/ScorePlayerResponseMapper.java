package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScorePlayerResponseMapper {
    @Mapping(source="scoreId",target="score.id")
    @Mapping(source="score",target="score.score")
    @Mapping(source="playerId",target="player.id")
    @Mapping(source="playerFirstName",target="player.playerFirstName")
    @Mapping(source="playerLastName",target="player.playerLastName")
    public abstract ScorePlayer mapScorePlayerResponseDtoToScorePlayer(ScorePlayerResponseDto scorePlayerResponseDto);
    @Mapping(source="score.id",target="scoreId")
    @Mapping(source="score.score",target="score")
    @Mapping(source="player.id",target="playerId")
    @Mapping(source="player.playerFirstName",target="playerFirstName")
    @Mapping(source="player.playerLastName",target="playerLastName")
    public abstract ScorePlayerResponseDto mapScorePlayerToScorePlayerResponseDto(ScorePlayer scorePlayer);

    public abstract List<ScorePlayerResponseDto> mapScorePlayerListToScorePlayerResponseDtoList(Collection<ScorePlayer> scorePlayerList);
    public abstract List<ScorePlayer> mapScorePlayerResponseDtoListToScorePlayerList(Collection<ScorePlayerResponseDto> scorePlayerResponseDtoList);
}
