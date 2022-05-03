package com.turnuvamvar.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScorePlayerDto {
    private Long playerId;
    private Long scoreId;
}
