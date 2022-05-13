package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Score extends BaseEntity {

    private int score;                                                          //countOfScore'du.
    @OneToOne(mappedBy = "scoreOfSecondTeam")
    private GamePerformed gamePerformedFirst;
    @OneToOne(mappedBy = "scoreOfSecondTeam")
    private GamePerformed gamePerformedSecond;

    @OneToMany(mappedBy = "score")
    private List<ScorePlayer> scoresPlayers;

}
