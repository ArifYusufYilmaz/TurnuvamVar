package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.PlayerToAddDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-03T00:40:38+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class PlayerToAddMapperImpl extends PlayerToAddMapper {

    @Override
    public PlayerToAddDto mapPlayerToAddToPlayerToAddDto(PlayerToAdd playerToAdd) {
        if ( playerToAdd == null ) {
            return null;
        }

        PlayerToAddDto playerToAddDto = new PlayerToAddDto();

        playerToAddDto.setPlayerFirstName( playerToAdd.getPlayerFirstName() );
        playerToAddDto.setPlayerLastName( playerToAdd.getPlayerLastName() );
        playerToAddDto.setPosition( playerToAdd.getPosition() );
        playerToAddDto.setPlayerAddress( playerToAdd.getPlayerAddress() );
        playerToAddDto.setPlayerPhoneNumber( playerToAdd.getPlayerPhoneNumber() );

        return playerToAddDto;
    }

    @Override
    public PlayerToAdd mapPlayerToAddDtoToPlayerToAdd(PlayerToAddDto playerToAddDto) {
        if ( playerToAddDto == null ) {
            return null;
        }

        PlayerToAdd playerToAdd = new PlayerToAdd();

        playerToAdd.setPlayerFirstName( playerToAddDto.getPlayerFirstName() );
        playerToAdd.setPlayerLastName( playerToAddDto.getPlayerLastName() );
        playerToAdd.setPosition( playerToAddDto.getPosition() );
        playerToAdd.setPlayerAddress( playerToAddDto.getPlayerAddress() );
        playerToAdd.setPlayerPhoneNumber( playerToAddDto.getPlayerPhoneNumber() );

        return playerToAdd;
    }

    @Override
    public List<PlayerToAddDto> mapPlayerToAddListToPlayerToAddDtoList(Collection<PlayerToAdd> playersToAdd) {
        if ( playersToAdd == null ) {
            return null;
        }

        List<PlayerToAddDto> list = new ArrayList<PlayerToAddDto>( playersToAdd.size() );
        for ( PlayerToAdd playerToAdd : playersToAdd ) {
            list.add( mapPlayerToAddToPlayerToAddDto( playerToAdd ) );
        }

        return list;
    }

    @Override
    public List<PlayerToAdd> mapPlayerToAddDtoListToPlayerToAddList(Collection<PlayerToAddDto> playersToAddDto) {
        if ( playersToAddDto == null ) {
            return null;
        }

        List<PlayerToAdd> list = new ArrayList<PlayerToAdd>( playersToAddDto.size() );
        for ( PlayerToAddDto playerToAddDto : playersToAddDto ) {
            list.add( mapPlayerToAddDtoToPlayerToAdd( playerToAddDto ) );
        }

        return list;
    }
}
