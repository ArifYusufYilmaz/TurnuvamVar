package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerCommunication;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T00:40:38+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class PlayerMapperImpl extends PlayerMapper {

    @Override
    public Player mapPlayerToAddDtoToPlayer(PlayerToAddDto newPlayerToAddDto) {
        if ( newPlayerToAddDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setPlayerCommunication( playerToAddDtoToPlayerCommunication( newPlayerToAddDto ) );
        player.setPlayerFirstName( newPlayerToAddDto.getPlayerFirstName() );
        player.setPlayerLastName( newPlayerToAddDto.getPlayerLastName() );
        player.setPosition( newPlayerToAddDto.getPosition() );

        return player;
    }

    protected PlayerCommunication playerToAddDtoToPlayerCommunication(PlayerToAddDto playerToAddDto) {
        if ( playerToAddDto == null ) {
            return null;
        }

        PlayerCommunication playerCommunication = new PlayerCommunication();

        playerCommunication.setPlayerAddress( playerToAddDto.getPlayerAddress() );
        playerCommunication.setPlayerPhoneNumber( playerToAddDto.getPlayerPhoneNumber() );

        return playerCommunication;
    }
}
