package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="players_to_add")
@Data

public class PlayerToAdd extends BaseEntity {
    private String playerFirstName;
    private String playerLastName;
    private String position;
    private String playerAddress;
    private String playerPhoneNumber;
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;
}
