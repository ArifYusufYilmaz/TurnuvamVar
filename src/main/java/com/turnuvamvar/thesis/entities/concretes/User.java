package com.turnuvamvar.thesis.entities.concretes;


import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Data
public class User extends BaseEntity {
    String userName;
    String password;
/*
    @OneToMany(mappedBy = "user")
    RefreshToken refreshToken;*/
}
