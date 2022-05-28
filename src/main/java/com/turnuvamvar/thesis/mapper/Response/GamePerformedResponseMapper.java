package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GamePerformedResponseMapper {
    @Mapping(source="gameToPlay.id",target="gameToPlayId")
    @Mapping(source="scoreOfFirstTeam.score",target="scoreOfFirstTeam")
    @Mapping(source="scoreOfSecondTeam.score",target="scoreOfSecondTeam")
    public abstract GamePerformedResponseDto mapGamePerformedToGamePerformedResponseDto(GamePerformed gamePerformed);
    @Mapping(source="gameToPlayId",target="gameToPlay.id")
    @Mapping(source="scoreOfFirstTeam",target="scoreOfFirstTeam.score")
    @Mapping(source="scoreOfSecondTeam",target="scoreOfSecondTeam.score")
    public abstract GamePerformed mapGamePerformedResponseDtoToGamePerformed(GamePerformedResponseDto gamePerformedResponseDto);

}
