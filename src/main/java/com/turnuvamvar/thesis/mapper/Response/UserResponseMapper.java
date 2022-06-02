package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.UserResponseDto;
import com.turnuvamvar.thesis.entities.concretes.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserResponseMapper {
    public abstract UserResponseDto mapUserToUserResponseDto(User user);
    public abstract User mapUserResponseDtoToUser(UserResponseDto userResponseDto);
}
