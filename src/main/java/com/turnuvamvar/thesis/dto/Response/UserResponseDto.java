package com.turnuvamvar.thesis.dto.Response;

import com.turnuvamvar.thesis.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    Long id;
    String email;
    String userName;
}
