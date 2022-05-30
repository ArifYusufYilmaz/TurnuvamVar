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
     // eşleşmeleri ifade edecek.
public class GameToPlay extends BaseEntity {

     /*@ManyToOne
     @JoinColumn(name="first_team")
     private List<Team> firstTeam;
     @ManyToOne
     @JoinColumn(name="second_team")
     private List<Team> secondTeam;*/

     private String Tarih; // tarih,saat  düzgün alınmalı, şimdilik bu şekilde!!

     /*@OneToOne(mappedBy = "gameToPlay")
     private GamePerformed gamePerformed;*/

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

    /* @OneToOne(cascade = CascadeType.MERGE) //
     @JoinColumn(name="stage_id", unique = true)
     private Stage stage; // aşamayı tutacak. enum'da yapabilirsin. ayrı tabloda da tutabilirsin.*/


     //@OneToOne(mappedBy="gameToPlay")
     //private Score score; // oynanan oyunlarla bağlantılı olsun.

}
