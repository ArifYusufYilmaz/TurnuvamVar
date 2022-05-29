package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.PlayerToAddResponseDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
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
public class PlayerToAddResponseMapperImpl extends PlayerToAddResponseMapper {

    @Override
    public PlayerToAddResponseDto mapPlayerToAddToPlayerToAddResponseDto(PlayerToAdd playerToAdd) {
        if ( playerToAdd == null ) {
            return null;
        }

        PlayerToAddResponseDto playerToAddResponseDto = new PlayerToAddResponseDto();

        playerToAddResponseDto.setTeamId( playerToAddTeamId( playerToAdd ) );
        playerToAddResponseDto.setTeamName( playerToAddTeamTeamName( playerToAdd ) );
        playerToAddResponseDto.setId( playerToAdd.getId() );
        playerToAddResponseDto.setPlayerFirstName( playerToAdd.getPlayerFirstName() );
        playerToAddResponseDto.setPlayerLastName( playerToAdd.getPlayerLastName() );
        playerToAddResponseDto.setPosition( playerToAdd.getPosition() );
        playerToAddResponseDto.setPlayerAddress( playerToAdd.getPlayerAddress() );
        playerToAddResponseDto.setPlayerPhoneNumber( playerToAdd.getPlayerPhoneNumber() );

        return playerToAddResponseDto;
    }

    @Override
    public PlayerToAdd mapPlayerToAddResponseDtoToPlayerToAdd(PlayerToAddResponseDto playerToAddResponseDto) {
        if ( playerToAddResponseDto == null ) {
            return null;
        }

        PlayerToAdd playerToAdd = new PlayerToAdd();

        playerToAdd.setTeam( playerToAddResponseDtoToTeam( playerToAddResponseDto ) );
        playerToAdd.setId( playerToAddResponseDto.getId() );
        playerToAdd.setPlayerFirstName( playerToAddResponseDto.getPlayerFirstName() );
        playerToAdd.setPlayerLastName( playerToAddResponseDto.getPlayerLastName() );
        playerToAdd.setPosition( playerToAddResponseDto.getPosition() );
        playerToAdd.setPlayerAddress( playerToAddResponseDto.getPlayerAddress() );
        playerToAdd.setPlayerPhoneNumber( playerToAddResponseDto.getPlayerPhoneNumber() );

        return playerToAdd;
    }

    @Override
    public List<PlayerToAddResponseDto> mapPlayerToAddListToPlayerToAddResponseDtoList(Collection<PlayerToAdd> playersToAdd) {
        if ( playersToAdd == null ) {
            return null;
        }

        List<PlayerToAddResponseDto> list = new ArrayList<PlayerToAddResponseDto>( playersToAdd.size() );
        for ( PlayerToAdd playerToAdd : playersToAdd ) {
            list.add( mapPlayerToAddToPlayerToAddResponseDto( playerToAdd ) );
        }

        return list;
    }

    @Override
    public List<PlayerToAdd> mapPlayerToAddResponseDtoListToPlayerToAddList(Collection<PlayerToAddResponseDto> playersToAddDto) {
        if ( playersToAddDto == null ) {
            return null;
        }

        List<PlayerToAdd> list = new ArrayList<PlayerToAdd>( playersToAddDto.size() );
        for ( PlayerToAddResponseDto playerToAddResponseDto : playersToAddDto ) {
            list.add( mapPlayerToAddResponseDtoToPlayerToAdd( playerToAddResponseDto ) );
        }

        return list;
    }

    private Long playerToAddTeamId(PlayerToAdd playerToAdd) {
        if ( playerToAdd == null ) {
            return null;
        }
        Team team = playerToAdd.getTeam();
        if ( team == null ) {
            return null;
        }
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String playerToAddTeamTeamName(PlayerToAdd playerToAdd) {
        if ( playerToAdd == null ) {
            return null;
        }
        Team team = playerToAdd.getTeam();
        if ( team == null ) {
            return null;
        }
        String teamName = team.getTeamName();
        if ( teamName == null ) {
            return null;
        }
        return teamName;
    }

    protected Team playerToAddResponseDtoToTeam(PlayerToAddResponseDto playerToAddResponseDto) {
        if ( playerToAddResponseDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( playerToAddResponseDto.getTeamId() );
        team.setTeamName( playerToAddResponseDto.getTeamName() );

        return team;
    }
}
