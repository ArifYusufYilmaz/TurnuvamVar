package com.turnuvamvar.thesis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageTeamResponseDto {
   private Long id;
   private Long stageId;
   private Long teamId;
   private String teamName;
   private String stageName; // mapperda stage.stageName yapacaksın

}
