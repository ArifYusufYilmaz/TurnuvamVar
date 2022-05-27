package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageTeamRequestDto {
    // TODO : ne dönmesi gerektiğini Utkuya sor
    private Long stageId;
    private Long teamId;
}
