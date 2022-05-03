package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.GameToPlayDto;
import com.turnuvamvar.thesis.entities.concretes.GameToPlay;
import com.turnuvamvar.thesis.entities.concretes.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GameToPlayMapper {

    @Mapping(source="stageTeamFirst.id", target="firstTeamId")
    @Mapping(source="stageTeamSecond.id", target="secondTeamId")
    public abstract GameToPlayDto mapGameToPlayToGameToPlayDto(GameToPlay gameToPlay);

    @Mapping(source="firstTeamId", target="stageTeamFirst.id")
    @Mapping(source="secondTeamId", target="stageTeamSecond.id")
    public abstract GameToPlay mapGameToPlayDtoToGameToPlay(GameToPlayDto gameToPlayDto);

    public abstract List<GameToPlayDto> mapGameToPlayToListGameToPlayDtoList(Collection<GameToPlay> gamesToPlay);
    public abstract List<GameToPlay> mapGameToPlayDtoListToGameToPlayList(Collection<GameToPlayDto> gamesToPlayDto);




}
