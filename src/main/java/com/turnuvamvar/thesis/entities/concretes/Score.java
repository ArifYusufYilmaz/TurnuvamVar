package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Score extends BaseEntity {

    private int score;                                                          //countOfScore'du.
    @OneToOne(mappedBy = "scoreOfSecondTeam", cascade = CascadeType.ALL)
    private GamePerformed gamePerformedFirst;
    @OneToOne(mappedBy = "scoreOfSecondTeam", cascade = CascadeType.ALL)
    private GamePerformed gamePerformedSecond;

    @OneToMany(mappedBy = "score", cascade = CascadeType.ALL)
    private List<ScorePlayer> scoresPlayers;

}
