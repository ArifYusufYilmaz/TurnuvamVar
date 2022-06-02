package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotNull(message = "User Name may not be null")
    @NotBlank(message = "User name may not be blank")
    @NotEmpty(message = "User name may not be blank")
    String userName;

    @NotNull(message = "Password may not be null")
    String password;
}
