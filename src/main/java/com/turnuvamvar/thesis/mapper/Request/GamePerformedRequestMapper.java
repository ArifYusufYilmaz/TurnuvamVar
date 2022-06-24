package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.GamePerformedRequestDto;
import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GamePerformedRequestMapper {
    @Mapping(source="gameToPlay.id",target="gameToPlayId")
    @Mapping(source="scoreOfFirstTeam.score",target="scoreOfFirstTeam")
    @Mapping(source="scoreOfSecondTeam.score",target="scoreOfSecondTeam")
    public abstract GamePerformedRequestDto mapGamePerformedToGamePerformedRequestDto(GamePerformed gamePerformed);
    @Mapping(source="gameToPlayId",target="gameToPlay.id")
    @Mapping(source="scoreOfFirstTeam",target="scoreOfFirstTeam.score")
    @Mapping(source="scoreOfSecondTeam",target="scoreOfSecondTeam.score")
    public abstract GamePerformed mapGamePerformedRequestDtoToGamePerformed(GamePerformedRequestDto gamePerformedRequestDto);
}
