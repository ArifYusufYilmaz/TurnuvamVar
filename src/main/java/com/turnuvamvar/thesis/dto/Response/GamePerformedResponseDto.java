package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePerformedResponseDto {
    private Long id;
    private int scoreOfFirstTeam;
    private int scoreOfSecondTeam;
    private Long gameToPlayId;
    private String firstTeamName;
    private String secondTeamName;
}
