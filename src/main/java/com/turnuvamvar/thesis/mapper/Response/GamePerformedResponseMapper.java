package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.GamePerformedResponseDto;
import com.turnuvamvar.thesis.entities.concretes.GamePerformed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GamePerformedResponseMapper {
    @Mapping(source="gameToPlay.id",target="gameToPlayId")
    @Mapping(source="scoreOfFirstTeam.id", target="scoreOfFirstTeamId")
    @Mapping(source="scoreOfFirstTeam.score",target="scoreOfFirstTeam")
    @Mapping(source = "scoreOfSecondTeam.id", target = "scoreOfSecondTeamId")
    @Mapping(source="scoreOfSecondTeam.score",target="scoreOfSecondTeam")
    @Mapping(source ="gameToPlay.stageTeamFirst.team.id", target="firstTeamId")
    @Mapping(source="gameToPlay.stageTeamFirst.team.teamName",target="firstTeamName")
    @Mapping(source ="gameToPlay.stageTeamSecond.team.id", target="secondTeamId")
    @Mapping(source="gameToPlay.stageTeamSecond.team.teamName",target="secondTeamName")
    @Mapping(source="gameToPlay.stageTeamFirst.stage.id", target = "stageId")
    public abstract GamePerformedResponseDto mapGamePerformedToGamePerformedResponseDto(GamePerformed gamePerformed);
    @Mapping(source="gameToPlayId",target="gameToPlay.id")
    @Mapping(source="scoreOfFirstTeamId", target = "scoreOfFirstTeam.id")
    @Mapping(source="scoreOfFirstTeam",target="scoreOfFirstTeam.score")
    @Mapping(source="scoreOfSecondTeamId", target="scoreOfSecondTeam.id")
    @Mapping(source="scoreOfSecondTeam",target="scoreOfSecondTeam.score")
    @Mapping(source ="firstTeamId", target="gameToPlay.stageTeamFirst.team.id")
    @Mapping(source="firstTeamName",target="gameToPlay.stageTeamFirst.team.teamName")
    @Mapping(source ="secondTeamId", target="gameToPlay.stageTeamSecond.team.id")
    @Mapping(source="secondTeamName",target="gameToPlay.stageTeamSecond.team.teamName")
    @Mapping(source="stageId", target="gameToPlay.stageTeamFirst.stage.id")
    public abstract GamePerformed mapGamePerformedResponseDtoToGamePerformed(GamePerformedResponseDto gamePerformedResponseDto);
    public abstract List<GamePerformed> mapGamePerformedResponseDtoListToGamePerformedList(Collection<GamePerformedResponseDto> gamePerformedResponseDtoList);
    public abstract List<GamePerformedResponseDto> mapGamePerformedListToGamePerformedResponseList(Collection<GamePerformed> gamePerformedList);
}
