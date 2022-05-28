package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GameToPlayResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GameToPlayResponseMapper {
     //commit
    @Mapping(source="stageTeamFirst.id", target="firstTeamId")
    @Mapping(source="stageTeamSecond.id", target="secondTeamId")
    public abstract GameToPlayResponseDto mapGameToPlayToGameToPlayResponseDto(GameToPlay gameToPlay);

    @Mapping(source="firstTeamId", target="stageTeamFirst.id")
    @Mapping(source="secondTeamId", target="stageTeamSecond.id")
    public abstract GameToPlay mapGameToPlayResponseDtoToGameToPlay(GameToPlayResponseDto gameToPlayResponseDto);

    public abstract List<GameToPlayResponseDto> mapGameToPlayToListGameToPlayResponseDtoList(Collection<GameToPlay> gamesToPlay);
    public abstract List<GameToPlay> mapGameToPlayResponseDtoListToGameToPlayList(Collection<GameToPlayResponseDto> gamesToPlayDto);




}
