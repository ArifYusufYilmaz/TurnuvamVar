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
    date = "2022-06-02T12:46:58+0300",
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
    public Player mapPlayerResponseDtoToPlayer(PlayerResponseDto playerToAddResponseDto) {
        if ( playerToAddResponseDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setPlayerCommunication( playerResponseDtoToPlayerCommunication( playerToAddResponseDto ) );
        player.setTeam( playerResponseDtoToTeam( playerToAddResponseDto ) );
        player.setId( playerToAddResponseDto.getId() );
        player.setPlayerFirstName( playerToAddResponseDto.getPlayerFirstName() );
        player.setPlayerLastName( playerToAddResponseDto.getPlayerLastName() );
        player.setPosition( playerToAddResponseDto.getPosition() );

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
        playerResponseDto.setPlayerAddress( playerPlayerCommunicationPlayerAddress( player ) );
        playerResponseDto.setPlayerPhoneNumber( playerPlayerCommunicationPlayerPhoneNumber( player ) );
        playerResponseDto.setTeamName( playerTeamTeamName( player ) );
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

    @Override
    public List<Player> mapPlayerResponseDtoListToPlayerList(Collection<PlayerResponseDto> playerResponseDtoList) {
        if ( playerResponseDtoList == null ) {
            return null;
        }

        List<Player> list = new ArrayList<Player>( playerResponseDtoList.size() );
        for ( PlayerResponseDto playerResponseDto : playerResponseDtoList ) {
            list.add( mapPlayerResponseDtoToPlayer( playerResponseDto ) );
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

    protected PlayerCommunication playerResponseDtoToPlayerCommunication(PlayerResponseDto playerResponseDto) {
        if ( playerResponseDto == null ) {
            return null;
        }

        PlayerCommunication playerCommunication = new PlayerCommunication();

        playerCommunication.setPlayerAddress( playerResponseDto.getPlayerAddress() );
        playerCommunication.setPlayerPhoneNumber( playerResponseDto.getPlayerPhoneNumber() );
        playerCommunication.setId( playerResponseDto.getPlayerCommunicationId() );

        return playerCommunication;
    }

    protected Team playerResponseDtoToTeam(PlayerResponseDto playerResponseDto) {
        if ( playerResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( playerResponseDto.getTeamId() );
        team.setTeamName( playerResponseDto.getTeamName() );

        return team;
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

    private String playerPlayerCommunicationPlayerAddress(Player player) {
        if ( player == null ) {
            return null;
        }
        PlayerCommunication playerCommunication = player.getPlayerCommunication();
        if ( playerCommunication == null ) {
            return null;
        }
        String playerAddress = playerCommunication.getPlayerAddress();
        if ( playerAddress == null ) {
            return null;
        }
        return playerAddress;
    }

    private String playerPlayerCommunicationPlayerPhoneNumber(Player player) {
        if ( player == null ) {
            return null;
        }
        PlayerCommunication playerCommunication = player.getPlayerCommunication();
        if ( playerCommunication == null ) {
            return null;
        }
        String playerPhoneNumber = playerCommunication.getPlayerPhoneNumber();
        if ( playerPhoneNumber == null ) {
            return null;
        }
        return playerPhoneNumber;
    }

    private String playerTeamTeamName(Player player) {
        if ( player == null ) {
            return null;
        }
        Team team = player.getTeam();
        if ( team == null ) {
            return null;
        }
        String teamName = team.getTeamName();
        if ( teamName == null ) {
            return null;
        }
        return teamName;
    }
}
