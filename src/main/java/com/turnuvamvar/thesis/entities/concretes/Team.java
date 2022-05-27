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
 private String captainFirstName;
 private String captainLastName;

 @ManyToOne
 @JsonBackReference
 private Tournament tournament;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "team_captain_id", unique = true)
 private TeamCaptain teamCaptain;

 @OneToMany(mappedBy = "team", cascade= CascadeType.ALL)
 private List<PlayerToAdd> playersToAdd;

 @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
 private List<Player> players;

 @OneToMany(mappedBy  = "team", cascade =CascadeType.ALL)
 private List<StageTeam> stageTeams;
 public Team(){
     createTeamCaptain();
  }
  private void createTeamCaptain(){
     this.teamCaptain = new TeamCaptain();
  }
}
