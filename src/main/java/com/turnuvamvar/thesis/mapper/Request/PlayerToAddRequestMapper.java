package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlayerToAddRequestMapper {
    public abstract PlayerToAddRequestDto mapPlayerToAddToPlayerToAddRequestDto(PlayerToAdd playerToAdd);
    public abstract PlayerToAdd mapPlayerToAddRequestDtoToPlayerToAdd(PlayerToAddRequestDto playerToAddRequestDto);

    public abstract List<PlayerToAddRequestDto> mapPlayerToAddListToPlayerToAddDtoList(Collection<PlayerToAdd> playersToAdd);
    public abstract List<PlayerToAdd> mapPlayerToAddDtoListToPlayerToAddList(Collection<PlayerToAddRequestDto> playersToAddRequestDto);
}
