package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponseDto {
    private Long id;
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private Long playerCommunicationId;
    private Long teamId;
}

