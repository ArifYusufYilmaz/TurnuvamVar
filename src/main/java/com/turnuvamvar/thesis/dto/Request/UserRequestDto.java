package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotNull(message = "Email may not be null")
    @Email(message = "You must provide a valid email")
    String email;

    @NotNull(message = "User Name may not be null")
    String userName;

    @NotNull(message = "Password may not be null")
    String password;
}
