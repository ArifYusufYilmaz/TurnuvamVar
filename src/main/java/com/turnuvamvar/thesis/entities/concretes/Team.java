package com.turnuvamvar.thesis.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Team extends BaseEntity {
    private String teamName;
   // private String teamCaptain; // ayrı tablo.
    @ManyToOne
    @JsonBackReference
    private Tournament tournament;

    @OneToOne
    @JoinColumn(name="team_captain_id", unique=true)
    private TeamCaptain teamCaptain;

    // takım kaptanı sınıfıyla bağlantı olmalı. isim ve soyisim alınıp uniqe bir kod ve şifre(ayrı tablo.) oluşturulmalı.
}
