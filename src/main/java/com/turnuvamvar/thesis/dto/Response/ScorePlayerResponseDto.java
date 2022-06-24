package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScorePlayerResponseDto {
    private Long id;
    private Long playerId;
    private String playerFirstName;
    private String playerLastName;
    private Long scoreId;
    private int score;
}
