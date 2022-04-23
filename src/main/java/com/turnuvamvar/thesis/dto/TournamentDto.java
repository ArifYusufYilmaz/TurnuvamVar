package com.turnuvamvar.thesis.dto;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDto  {
    private Long id;
    private String tournamentName;
    private String description;

}