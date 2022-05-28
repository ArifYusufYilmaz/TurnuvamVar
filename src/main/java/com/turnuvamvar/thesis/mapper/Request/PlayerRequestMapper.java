package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PlayerRequestMapper {
    @Mapping(source = "playerAddress", target ="playerCommunication.playerAddress" )
    @Mapping(source = "playerPhoneNumber", target ="playerCommunication.playerPhoneNumber" )
    public abstract Player mapPlayerToAddRequestDtoToPlayer(PlayerToAddRequestDto newPlayerToAddRequestDto);
}
