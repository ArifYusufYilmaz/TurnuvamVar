package com.turnuvamvar.thesis.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageResponseDto {
    private Long id;
    private String stageName;
    private Long tournamentId;
    private String tournamentName;

}
