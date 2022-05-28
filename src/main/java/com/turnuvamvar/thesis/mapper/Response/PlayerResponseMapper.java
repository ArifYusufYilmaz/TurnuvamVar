package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PlayerResponseMapper {
    @Mapping(source = "playerAddress", target ="playerCommunication.playerAddress" )
    @Mapping(source = "playerPhoneNumber", target ="playerCommunication.playerPhoneNumber" )
    public abstract Player mapPlayerToAddResponseDtoToPlayer(PlayerToAddResponseDto newPlayerToAddResponseDto);


    //
}
