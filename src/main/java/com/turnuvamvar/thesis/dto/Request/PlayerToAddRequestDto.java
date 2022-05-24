package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerToAddRequestDto {
    private Long id;
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private String playerAddress;
    private String playerPhoneNumber;
    private Long teamId;
}
