package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.PlayerToAddRequestDto;
import com.turnuvamvar.thesis.entities.concretes.PlayerToAdd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-05T02:59:56+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class PlayerToAddRequestMapperImpl extends PlayerToAddRequestMapper {

    @Override
    public PlayerToAddRequestDto mapPlayerToAddToPlayerToAddRequestDto(PlayerToAdd playerToAdd) {
        if ( playerToAdd == null ) {
            return null;
        }

        PlayerToAddRequestDto playerToAddRequestDto = new PlayerToAddRequestDto();

        playerToAddRequestDto.setPlayerFirstName( playerToAdd.getPlayerFirstName() );
        playerToAddRequestDto.setPlayerLastName( playerToAdd.getPlayerLastName() );
        playerToAddRequestDto.setPosition( playerToAdd.getPosition() );
        playerToAddRequestDto.setPlayerAddress( playerToAdd.getPlayerAddress() );
        playerToAddRequestDto.setPlayerPhoneNumber( playerToAdd.getPlayerPhoneNumber() );

        return playerToAddRequestDto;
    }

    @Override
    public PlayerToAdd mapPlayerToAddRequestDtoToPlayerToAdd(PlayerToAddRequestDto playerToAddRequestDto) {
        if ( playerToAddRequestDto == null ) {
            return null;
        }

        PlayerToAdd playerToAdd = new PlayerToAdd();

        playerToAdd.setPlayerFirstName( playerToAddRequestDto.getPlayerFirstName() );
        playerToAdd.setPlayerLastName( playerToAddRequestDto.getPlayerLastName() );
        playerToAdd.setPosition( playerToAddRequestDto.getPosition() );
        playerToAdd.setPlayerAddress( playerToAddRequestDto.getPlayerAddress() );
        playerToAdd.setPlayerPhoneNumber( playerToAddRequestDto.getPlayerPhoneNumber() );

        return playerToAdd;
    }

    @Override
    public List<PlayerToAddRequestDto> mapPlayerToAddListToPlayerToAddDtoList(Collection<PlayerToAdd> playersToAdd) {
        if ( playersToAdd == null ) {
            return null;
        }

        List<PlayerToAddRequestDto> list = new ArrayList<PlayerToAddRequestDto>( playersToAdd.size() );
        for ( PlayerToAdd playerToAdd : playersToAdd ) {
            list.add( mapPlayerToAddToPlayerToAddRequestDto( playerToAdd ) );
        }

        return list;
    }

    @Override
    public List<PlayerToAdd> mapPlayerToAddDtoListToPlayerToAddList(Collection<PlayerToAddRequestDto> playersToAddRequestDto) {
        if ( playersToAddRequestDto == null ) {
            return null;
        }

        List<PlayerToAdd> list = new ArrayList<PlayerToAdd>( playersToAddRequestDto.size() );
        for ( PlayerToAddRequestDto playerToAddRequestDto : playersToAddRequestDto ) {
            list.add( mapPlayerToAddRequestDtoToPlayerToAdd( playerToAddRequestDto ) );
        }

        return list;
    }
}
