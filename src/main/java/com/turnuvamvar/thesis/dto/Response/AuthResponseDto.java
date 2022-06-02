package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// login olduğunda dönülecek response
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    String message;
    Long userId;
    String accessToken;
    String refreshToken;
}
