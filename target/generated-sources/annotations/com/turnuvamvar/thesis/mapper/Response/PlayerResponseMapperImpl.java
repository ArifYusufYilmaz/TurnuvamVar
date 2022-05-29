package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.PlayerResponseDto;
import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.PlayerCommunication;
import com.turnuvamvar.thesis.entities.concretes.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T19:32:57+0300",
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
        player.setId( newPlayerToAddResponseDto.getId() );
        player.setPlayerFirstName( newPlayerToAddResponseDto.getPlayerFirstName() );
        player.setPlayerLastName( newPlayerToAddResponseDto.getPlayerLastName() );
        player.setPosition( newPlayerToAddResponseDto.getPosition() );

        return player;
    }

    @Override
    public PlayerResponseDto mapPlayerToPlayerResponseDto(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerResponseDto playerResponseDto = new PlayerResponseDto();

        playerResponseDto.setPlayerCommunicationId( playerPlayerCommunicationId( player ) );
        playerResponseDto.setTeamId( playerTeamId( player ) );
        playerResponseDto.setId( player.getId() );
        playerResponseDto.setPlayerFirstName( player.getPlayerFirstName() );
        playerResponseDto.setPlayerLastName( player.getPlayerLastName() );
        playerResponseDto.setPosition( player.getPosition() );

        return playerResponseDto;
    }

    @Override
    public List<PlayerResponseDto> mapPlayerListToPlayerResponseDtoList(Collection<Player> playerList) {
        if ( playerList == null ) {
            return null;
        }

        List<PlayerResponseDto> list = new ArrayList<PlayerResponseDto>( playerList.size() );
        for ( Player player : playerList ) {
            list.add( mapPlayerToPlayerResponseDto( player ) );
        }

        return list;
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

    private Long playerPlayerCommunicationId(Player player) {
        if ( player == null ) {
            return null;
        }
        PlayerCommunication playerCommunication = player.getPlayerCommunication();
        if ( playerCommunication == null ) {
            return null;
        }
        Long id = playerCommunication.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long playerTeamId(Player player) {
        if ( player == null ) {
            return null;
        }
        Team team = player.getTeam();
        if ( team == null ) {
            return null;
        }
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
