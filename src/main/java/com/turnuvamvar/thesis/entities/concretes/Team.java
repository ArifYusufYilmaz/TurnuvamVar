package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data

public class Team extends BaseEntity {
    private String teamName;
   // private String teamCaptain; // ayrı tablo.
    @ManyToOne
    @JsonBackReference
    private Tournament tournament;
}
