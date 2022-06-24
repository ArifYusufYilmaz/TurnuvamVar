package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="games_to_play")
@Data
public class GameToPlay extends BaseEntity {

     private String Tarih;                                            // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!
     @OneToOne
     @JoinColumn(unique = true)
     @OnDelete(action = OnDeleteAction.CASCADE)
     private StageTeam stageTeamFirst;
     @OneToOne
     @JoinColumn(unique = true)
     @OnDelete(action = OnDeleteAction.CASCADE)
     private StageTeam stageTeamSecond;
     @OneToOne(mappedBy = "gameToPlay", cascade = CascadeType.REMOVE) //
     private GamePerformed gamePerformed;
}
