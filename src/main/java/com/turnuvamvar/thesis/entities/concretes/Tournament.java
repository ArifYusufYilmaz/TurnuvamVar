package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="tournaments")
@Data

public class Tournament extends BaseEntity {
    private String tournamentName;
    private String description;
    @OneToMany(mappedBy="tournament")
    @JsonManagedReference
    private List<Team> team;
}
