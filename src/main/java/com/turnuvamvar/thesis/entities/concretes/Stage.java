package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "stages")
@Data
public class Stage extends BaseEntity {
    private String stageName;
    private int requiredTeamCount;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    private List<StageTeam> stagesTeams;

    @ManyToOne
    @JsonBackReference
    private Tournament tournament;
}

