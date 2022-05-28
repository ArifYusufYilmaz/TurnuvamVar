package com.turnuvamvar.thesis.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameToPlayRequestDto {
    private Long firstTeamId; // stageteamfirstid;
    private Long secondTeamId;  //stageteamsecondid
    private String Tarih; // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!
}
