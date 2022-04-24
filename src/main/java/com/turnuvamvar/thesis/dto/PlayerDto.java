package com.turnuvamvar.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private Long playerCommunicationId;
}

