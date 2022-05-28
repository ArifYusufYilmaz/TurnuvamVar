package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
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
public class PlayerRequestMapperImpl extends PlayerRequestMapper {

    @Override
    public Player mapPlayerToAddRequestDtoToPlayer(PlayerToAddRequestDto newPlayerToAddRequestDto) {
        if ( newPlayerToAddRequestDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setPlayerCommunication( playerToAddRequestDtoToPlayerCommunication( newPlayerToAddRequestDto ) );
        player.setId( newPlayerToAddRequestDto.getId() );
        player.setPlayerFirstName( newPlayerToAddRequestDto.getPlayerFirstName() );
        player.setPlayerLastName( newPlayerToAddRequestDto.getPlayerLastName() );
        player.setPosition( newPlayerToAddRequestDto.getPosition() );

        return player;
    }

    protected PlayerCommunication playerToAddRequestDtoToPlayerCommunication(PlayerToAddRequestDto playerToAddRequestDto) {
        if ( playerToAddRequestDto == null ) {
            return null;
        }

        PlayerCommunication playerCommunication = new PlayerCommunication();

        playerCommunication.setPlayerAddress( playerToAddRequestDto.getPlayerAddress() );
        playerCommunication.setPlayerPhoneNumber( playerToAddRequestDto.getPlayerPhoneNumber() );

        return playerCommunication;
    }
}
