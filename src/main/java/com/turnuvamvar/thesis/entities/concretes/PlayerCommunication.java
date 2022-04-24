package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class PlayerCommunication extends BaseEntity {
    private String playerAddress;
    private String playerPhoneNumber;
    // gerekli alanlar daha sonra eklenebilir!!
    @OneToOne(mappedBy= "playerCommunication")
    private Player player;
}
