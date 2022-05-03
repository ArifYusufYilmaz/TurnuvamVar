package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data   // şuanlık(veya tamamen) bu tablo iptal
public class Score extends BaseEntity {

    private int countOfScore;
    @OneToOne(mappedBy = "scoreOfSecondTeam")
    private GamePerformed gamePerformedFirst;
    @OneToOne(mappedBy = "scoreOfSecondTeam")
    private GamePerformed gamePerformedSecond;

    @OneToMany(mappedBy = "score")
    private List<ScorePlayer> scoresPlayers;

}
