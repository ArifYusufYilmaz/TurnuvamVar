package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequestDto {

    private String tournamentName;
    private String description;
}
