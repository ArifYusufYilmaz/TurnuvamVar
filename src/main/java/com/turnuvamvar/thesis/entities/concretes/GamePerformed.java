package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="games_performed")  // gametoplayid ile hangi maç olduğu alınacak, 1. ve 2. takım skorları ve diğer olaylar(kim attı vs)
@Data
public class GamePerformed extends BaseEntity {

    @OneToOne(cascade=CascadeType.ALL) //
    @JoinColumn(name="score_of_first_team_id", unique = true)
    private Score scoreOfFirstTeam;
    @OneToOne(cascade=CascadeType.ALL) //
    @JoinColumn(name="score_of_second_team_id", unique = true)
    private Score scoreOfSecondTeam;

    @OneToOne(cascade = CascadeType.MERGE) //
    @JoinColumn(name="game_to_play_id", unique = true)
    private GameToPlay gameToPlay;
}
