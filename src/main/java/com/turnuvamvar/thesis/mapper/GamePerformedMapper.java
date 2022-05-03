package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.GamePerformedDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class GamePerformedMapper {
    @Mapping(source="gameToPlay.id",target="gameToPlayId")
    @Mapping(source="scoreOfFirstTeam.countOfScore",target="scoreOfFirstTeam")
    @Mapping(source="scoreOfSecondTeam.countOfScore",target="scoreOfSecondTeam")
    public abstract GamePerformedDto mapGamePerformedToGamePerformedDto(GamePerformed gamePerformed);
    @Mapping(source="gameToPlayId",target="gameToPlay.id")
    @Mapping(source="scoreOfFirstTeam",target="scoreOfFirstTeam.countOfScore")
    @Mapping(source="scoreOfSecondTeam",target="scoreOfSecondTeam.countOfScore")
    public abstract GamePerformed mapGamePerformedDtoToGamePerformed(GamePerformedDto gamePerformedDto);
}
