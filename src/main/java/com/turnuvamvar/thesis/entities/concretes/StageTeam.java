package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data                                         // Join table with Stage and Team
public class StageTeam extends BaseEntity {   // ManyToMany olması gereken stage-team ilişkisini daha etkin kullanabilmek için bu şekilde kullanıyorum

    @ManyToOne
    private Stage stage;
    @ManyToOne
    private Team team;
    @OneToOne(mappedBy = "stageTeamFirst")
    private GameToPlay gameToPlayFirst;

    @OneToOne(mappedBy = "stageTeamSecond")
    private GameToPlay gameToPlaySecond;

}
