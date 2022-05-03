package com.turnuvamvar.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePerformedDto {
    private int scoreOfFirstTeam;
    private int scoreOfSecondTeam;
    private Long gameToPlayId;
}
