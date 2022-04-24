package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.business.abstracts.PlayerToAddService;
import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlayerToAddMapper {
    @Autowired
    protected PlayerToAddService playerToAddService;

    public abstract PlayerToAddDto mapPlayerToAddToPlayerToAddDto(PlayerToAdd playerToAdd);
    public abstract PlayerToAdd mapPlayerToAddDtoToPlayerToAdd(PlayerToAddDto playerToAddDto);

    public abstract List<PlayerToAddDto> mapPlayerToAddListToPlayerToAddDtoList(Collection<PlayerToAdd> playersToAdd);
    public abstract List<PlayerToAdd> mapPlayerToAddDtoListToPlayerToAddList(Collection<PlayerToAddDto> playersToAddDto);
}
