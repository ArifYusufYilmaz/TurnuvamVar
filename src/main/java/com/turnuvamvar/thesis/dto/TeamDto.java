package com.turnuvamvar.thesis.dto;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto  {
    private Long id;
    private String teamName;
    private String captainFirstName;
    private String captainLastName;
    private Long teamCaptainId;

}
