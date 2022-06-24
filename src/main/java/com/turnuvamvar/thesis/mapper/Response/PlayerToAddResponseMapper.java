package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlayerToAddResponseMapper {
    @Mapping(source="team.id", target = "teamId")
    @Mapping(source="team.teamName",target="teamName")
    public abstract PlayerToAddResponseDto mapPlayerToAddToPlayerToAddResponseDto(PlayerToAdd playerToAdd);
    @Mapping(source="teamId", target = "team.id")
    @Mapping(source="teamName",target="team.teamName")
    public abstract PlayerToAdd mapPlayerToAddResponseDtoToPlayerToAdd(PlayerToAddResponseDto playerToAddResponseDto);
    public abstract List<PlayerToAddResponseDto> mapPlayerToAddListToPlayerToAddResponseDtoList(Collection<PlayerToAdd> playersToAdd);
    public abstract List<PlayerToAdd> mapPlayerToAddResponseDtoListToPlayerToAddList(Collection<PlayerToAddResponseDto> playersToAddDto);
}
