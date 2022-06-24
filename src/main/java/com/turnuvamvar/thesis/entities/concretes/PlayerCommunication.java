package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="players_communication")
@Data
public class PlayerCommunication extends BaseEntity {
    private String playerAddress;
    private String playerPhoneNumber;
    @OneToOne(mappedBy= "playerCommunication")
    private Player player;
}
