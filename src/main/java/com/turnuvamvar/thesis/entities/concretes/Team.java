package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teams")
@Data

public class Team extends BaseEntity {
    private String teamName;
   // private String teamCaptain; // ayrı tablo.
    private String captainFirstName;
    private String captainLastName;

    @ManyToOne
    @JsonBackReference
    private Tournament tournament;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="team_captain_id", unique=true)
    private TeamCaptain teamCaptain;

    @OneToMany(mappedBy="team")
    private List<PlayerToAdd> playersToAdd;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

   /* @OneToMany(mappedBy = "firstTeam")
    private GameToPlay gameToPlayFirstTeam;

    @OneToMany(mappedBy = "secondTeam")
    private GameToPlay gameToPlaySecondTeam;*/

    @OneToMany(mappedBy  = "team")
    private List<StageTeam> stageTeams;





    public Team(){
        createTeamCaptain();

    }
    private void createTeamCaptain(){
        this.teamCaptain = new TeamCaptain();

    }
    // takım kaptanı sınıfıyla bağlantı olmalı. isim ve soyisim alınıp uniqe bir kod ve şifre(ayrı tablo.) oluşturulmalı.
}
