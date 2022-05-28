package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlayerToAddResponseMapper {
    @Autowired
    protected PlayerToAddService playerToAddService;

    public abstract PlayerToAddResponseDto mapPlayerToAddToPlayerToAddResponseDto(PlayerToAdd playerToAdd);
    public abstract PlayerToAdd mapPlayerToAddResponseDtoToPlayerToAdd(PlayerToAddResponseDto playerToAddResponseDto);

    public abstract List<PlayerToAddResponseDto> mapPlayerToAddListToPlayerToAddResponseDtoList(Collection<PlayerToAdd> playersToAdd);
    public abstract List<PlayerToAdd> mapPlayerToAddResponseDtoListToPlayerToAddList(Collection<PlayerToAddResponseDto> playersToAddDto);
}
