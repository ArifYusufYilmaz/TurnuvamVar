package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ScorePlayer extends BaseEntity { // Join table with Score and Player

    @ManyToOne
    private Score score;
    @ManyToOne
    private Player player;
}
