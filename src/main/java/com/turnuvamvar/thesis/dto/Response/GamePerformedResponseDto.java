package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePerformedResponseDto {
    private Long id;
    private Long scoreOfFirstTeamId;
    private Long scoreOfSecondTeamId;
    private int scoreOfFirstTeam;
    private int scoreOfSecondTeam;
    private Long gameToPlayId;
    private Long firstTeamId;
    private String firstTeamName;
    private Long secondTeamId;
    private String secondTeamName;
    private Long stageId;
}
