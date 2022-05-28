package com.turnuvamvar.thesis.dto.Response;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private Long id;
    private String teamName;
    private String captainFirstName;
    private String captainLastName;
    private Long teamCaptainId;
    private String tournamentName;
    private Long tournamentId;
}
