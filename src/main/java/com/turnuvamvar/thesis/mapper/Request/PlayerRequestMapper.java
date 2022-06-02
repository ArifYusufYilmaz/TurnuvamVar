package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.PlayerRequestDto;
import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PlayerRequestMapper {
    /*@Mapping(source = "playerAddress", target ="playerCommunication.playerAddress" )
    @Mapping(source = "playerPhoneNumber", target ="playerCommunication.playerPhoneNumber" )
    public abstract Player mapPlayerToAddRequestDtoToPlayer(PlayerToAddRequestDto newPlayerToAddRequestDto);

    @Mapping(source="team.id",target="teamId")
    @Mapping(source="playerCommunication.id",target="playerCommunicationId")
    @Mapping(source="playerCommunication.playerPhoneNumber",target="playerPhoneNumber")
    @Mapping(source="playerCommunication.playerAddress",target="playerAddress")
    public abstract PlayerRequestDto mapPlayerToPlayerRequestDto(Player player);


    @Mapping(source="playerAddress",target="playerCommunication.playerAddress")
    @Mapping(source="playerPhoneNumber",target="playerCommunication.playerPhoneNumber")
    @Mapping(source="teamId",target="team.id")
    @Mapping(source="playerCommunicationId",target="playerCommunication.id")
    public abstract Player mapPlayerRequestDtoToPlayer(Player player);*/


}
