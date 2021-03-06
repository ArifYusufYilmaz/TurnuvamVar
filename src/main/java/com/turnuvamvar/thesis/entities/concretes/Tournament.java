package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tournaments")
@Data

public class Tournament extends BaseEntity {
    private String tournamentName;
    private String description;

    @OneToMany(mappedBy="tournament", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Team> team;

    @OneToMany(mappedBy="tournament", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Stage> stage;
}




// Team will be deleted in case tournament will be deleted.
// it should be done on the other classes too.