package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data

public class PlayerToAdd extends BaseEntity {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private String playerAddress;
    private String playerPhoneNumber;
}
