package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.GameToPlayRequestDto;
import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GameToPlayRequestMapper {
    @Mapping(source="stageTeamFirst.id", target="firstStageTeamId")
    @Mapping(source="stageTeamSecond.id", target="secondStageTeamId")
    public abstract GameToPlayRequestDto mapGameToPlayToGameToPlayRequestDto(GameToPlay gameToPlay);
    @Mapping(source="firstStageTeamId", target="stageTeamFirst.id")
    @Mapping(source="secondStageTeamId", target="stageTeamSecond.id")
    public abstract GameToPlay mapGameToPlayRequestDtoToGameToPlay(GameToPlayRequestDto gameToPlayRequestDto);
    public abstract List<GameToPlayRequestDto> mapGameToPlayListToGameToPlayRequestDtoList(Collection<GameToPlay> gamesToPlay);
    public abstract List<GameToPlay> mapGameToPlayRequestDtoListToGameToPlayList(Collection<GameToPlayRequestDto> gamesToPlayDto);

}
