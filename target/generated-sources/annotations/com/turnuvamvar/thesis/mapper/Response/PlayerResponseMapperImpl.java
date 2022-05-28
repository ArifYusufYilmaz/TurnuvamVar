package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerCommunication;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-28T21:33:06+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class PlayerResponseMapperImpl extends PlayerResponseMapper {

    @Override
    public Player mapPlayerToAddResponseDtoToPlayer(PlayerToAddResponseDto newPlayerToAddResponseDto) {
        if ( newPlayerToAddResponseDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setPlayerCommunication( playerToAddResponseDtoToPlayerCommunication( newPlayerToAddResponseDto ) );
        player.setPlayerFirstName( newPlayerToAddResponseDto.getPlayerFirstName() );
        player.setPlayerLastName( newPlayerToAddResponseDto.getPlayerLastName() );
        player.setPosition( newPlayerToAddResponseDto.getPosition() );

        return player;
    }

    protected PlayerCommunication playerToAddResponseDtoToPlayerCommunication(PlayerToAddResponseDto playerToAddResponseDto) {
        if ( playerToAddResponseDto == null ) {
            return null;
        }

        PlayerCommunication playerCommunication = new PlayerCommunication();

        playerCommunication.setPlayerAddress( playerToAddResponseDto.getPlayerAddress() );
        playerCommunication.setPlayerPhoneNumber( playerToAddResponseDto.getPlayerPhoneNumber() );

        return playerCommunication;
    }
}
