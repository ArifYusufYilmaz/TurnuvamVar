package com.turnuvamvar.thesis.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDto {
    private String teamName;
    private String captainFirstName;
    private String captainLastName;

}
