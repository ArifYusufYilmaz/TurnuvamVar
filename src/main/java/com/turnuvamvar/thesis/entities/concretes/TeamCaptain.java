package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class TeamCaptain extends BaseEntity {
    private  String captainFirstName;
    private  String captainLastName;

    @OneToOne(mappedBy="teamCaptain")
    private Team team;

    @OneToOne
    @JoinColumn(name = "team_code_id", unique = true)
    private TeamCode teamCode;
    /*private String teamCode;
    private String teamPassword;*/
}
