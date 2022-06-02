package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequestDto {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private Long playerCommunicationId;
    private Long teamId;

    private String playerAddress;
    private String playerPhoneNumber;
}
