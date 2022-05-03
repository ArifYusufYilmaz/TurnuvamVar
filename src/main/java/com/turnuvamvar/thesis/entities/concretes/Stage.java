package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "stages")
@Data
public class Stage extends BaseEntity {
    private String stageName;   // enum yapılabilir!

    /*@OneToOne(mappedBy = "stage")
    private GameToPlay gameToPlay;*/

    /*@ManyToMany
    @JoinTable(name ="stage_team",
            joinColumns = {@JoinColumn(name="stage_id")},
            inverseJoinColumns={@JoinColumn(name="team_id")})
    private List<Team> teams;*/

    @OneToMany(mappedBy = "stage")
    private List<StageTeam> stagesTeams;
}

