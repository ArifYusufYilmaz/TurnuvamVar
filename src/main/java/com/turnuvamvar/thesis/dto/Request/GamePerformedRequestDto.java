package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePerformedRequestDto {
    private int scoreOfFirstTeam;
    private int scoreOfSecondTeam;
    private Long gameToPlayId;
}
