package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class StageTeam extends BaseEntity {

    @ManyToOne
    private Stage stage;
    @ManyToOne
    private Team team;
    @OneToOne(mappedBy = "stageTeamFirst", cascade= CascadeType.ALL)
    private GameToPlay gameToPlayFirst;

    @OneToOne(mappedBy = "stageTeamSecond", cascade = CascadeType.ALL)
    private GameToPlay gameToPlaySecond;

}

// Join table with Stage and Team
