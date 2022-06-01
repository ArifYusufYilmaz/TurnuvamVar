package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameToPlayRequestDto {
    private Long firstStageTeamId; // stageteamfirstid;
    private Long secondStageTeamId;  //stageteamsecondid
    private String Tarih; // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!

}
