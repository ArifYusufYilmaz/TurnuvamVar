package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlayerResponseMapper {
    @Mapping(source = "playerAddress", target ="playerCommunication.playerAddress" )
    @Mapping(source = "playerPhoneNumber", target ="playerCommunication.playerPhoneNumber" )
    public abstract Player mapPlayerToAddResponseDtoToPlayer(PlayerToAddResponseDto newPlayerToAddResponseDto);

    @Mapping(source="playerCommunication.id",target="playerCommunicationId")
    @Mapping(source ="team.id",target="teamId")
    public abstract PlayerResponseDto mapPlayerToPlayerResponseDto(Player player);

    public abstract List<PlayerResponseDto> mapPlayerListToPlayerResponseDtoList(Collection<Player> playerList);
}
