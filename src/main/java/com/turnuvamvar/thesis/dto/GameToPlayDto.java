package com.turnuvamvar.thesis.dto;

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
public class GameToPlayDto {


    private Long firstTeamId; // stageteamfirstid;
    private Long secondTeamId;  //stageteamsecondid
    private String Tarih; // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!

   // private Long stageId;
    //private Long scoreId;
}
