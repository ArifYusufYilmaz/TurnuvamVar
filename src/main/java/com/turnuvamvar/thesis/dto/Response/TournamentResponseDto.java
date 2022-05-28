package com.turnuvamvar.thesis.dto.Response;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentResponseDto {

    private Long id;
    private String tournamentName;
    private String description;

}
