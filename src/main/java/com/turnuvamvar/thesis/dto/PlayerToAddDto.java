package com.turnuvamvar.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerToAddDto {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private String playerAddress;
    private String playerPhoneNumber;
}
