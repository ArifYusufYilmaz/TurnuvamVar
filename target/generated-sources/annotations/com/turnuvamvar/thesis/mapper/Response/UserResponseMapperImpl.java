package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.UserResponseDto;
import com.turnuvamvar.thesis.entities.concretes.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T21:42:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UserResponseMapperImpl extends UserResponseMapper {

    @Override
    public UserResponseDto mapUserToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( user.getId() );
        userResponseDto.setEmail( user.getEmail() );
        userResponseDto.setUserName( user.getUserName() );

        return userResponseDto;
    }

    @Override
    public User mapUserResponseDtoToUser(UserResponseDto userResponseDto) {
        if ( userResponseDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userResponseDto.getId() );
        user.setEmail( userResponseDto.getEmail() );
        user.setUserName( userResponseDto.getUserName() );

        return user;
    }
}
