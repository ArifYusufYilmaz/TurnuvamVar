package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="players")
@Data
public class Player extends BaseEntity {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    // gerekli alanlar daha sonra eklenebilir!!
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_communication_id", unique = true)
    private PlayerCommunication playerCommunication;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "player")
    private List<ScorePlayer> scoresPlayers;
}
