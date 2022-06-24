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
    @Mapping(source = "playerAddress", target ="playerCommunication.playerAddress" )
    @Mapping(source = "playerPhoneNumber", target ="playerCommunication.playerPhoneNumber" )
    @Mapping(source="playerCommunicationId",target="playerCommunication.id")
    @Mapping(source ="teamId",target="team.id")
    @Mapping(source="teamName",target="team.teamName")
    public abstract Player mapPlayerResponseDtoToPlayer(PlayerResponseDto playerToAddResponseDto);
    @Mapping(source="playerCommunication.id",target="playerCommunicationId")
    @Mapping(source ="team.id",target="teamId")
    @Mapping(source = "playerCommunication.playerAddress", target = "playerAddress")
    @Mapping(source = "playerCommunication.playerPhoneNumber", target ="playerPhoneNumber" )
    @Mapping(source="team.teamName",target="teamName")
    public abstract PlayerResponseDto mapPlayerToPlayerResponseDto(Player player);
    public abstract List<PlayerResponseDto> mapPlayerListToPlayerResponseDtoList(Collection<Player> playerList);
    public abstract List<Player> mapPlayerResponseDtoListToPlayerList(Collection<PlayerResponseDto> playerResponseDtoList);
}
