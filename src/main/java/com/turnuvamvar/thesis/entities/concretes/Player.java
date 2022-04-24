package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Player extends BaseEntity {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    // gerekli alanlar daha sonra eklenebilir!!
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_communication_id", unique = true)
    private PlayerCommunication playerCommunication;
}
