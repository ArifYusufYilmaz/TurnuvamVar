package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GameToPlayResponseMapper {
    @Mapping(source="stageTeamFirst.id", target="firstStageTeamId")
    @Mapping(source="stageTeamFirst.team.teamName", target="firstTeamName")

    @Mapping(source="stageTeamSecond.id", target="secondStageTeamId")
    @Mapping(source="stageTeamSecond.team.teamName", target="secondTeamName")

    public abstract GameToPlayResponseDto mapGameToPlayToGameToPlayResponseDto(GameToPlay gameToPlay);

    @Mapping(source="firstStageTeamId", target="stageTeamFirst.id")
    @Mapping(source="secondStageTeamId", target="stageTeamSecond.id")
    @Mapping(source="firstTeamName", target="stageTeamFirst.team.teamName")
    @Mapping(source="secondTeamName", target="stageTeamSecond.team.teamName")
    public abstract GameToPlay mapGameToPlayResponseDtoToGameToPlay(GameToPlayResponseDto gameToPlayResponseDto);

    public abstract List<GameToPlayResponseDto> mapGameToPlayListToGameToPlayResponseDtoList(Collection<GameToPlay> gamesToPlay);
    public abstract List<GameToPlay> mapGameToPlayResponseDtoListToGameToPlayList(Collection<GameToPlayResponseDto> gamesToPlayDto);




}
