package com.turnuvamvar.thesis.dto.Response;

import com.turnuvamvar.thesis.entities.concretes.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameToPlayResponseDto {

    private Long id;
    private Long firstStageTeamId; // stageteamfirstid;
    private Long secondStageTeamId;  //stageteamsecondid
    private String Tarih; // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!
    private String firstTeamName;    //
    private String secondTeamName;

}
