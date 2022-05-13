package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.core.CodeAndPassword.entities.abstracts.AutoGenerateTeamCodeInfo;
import com.turnuvamvar.thesis.core.CodeAndPassword.entities.concretes.Code;
import com.turnuvamvar.thesis.core.CodeAndPassword.entities.concretes.Password;
import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="team_codes")
@Data
public class TeamCode extends BaseEntity {

    private  String teamCode;
    private  String teamPassword;

    @OneToOne(mappedBy="teamCode", cascade = CascadeType.ALL)
    private TeamCaptain teamCaptain;

    public TeamCode(){
         setTeamCode();
         setTeamPassword();
    }

    /*public TeamCode(String teamCode, String teamPassword) {     // Gerekmeyebilir.
        this.teamCode = teamCode;
        this.teamPassword = teamPassword;
        setTeamCode();
        setTeamPassword();
    }*/

    private void setTeamCode(){
        AutoGenerateTeamCodeInfo autoGeneratorCode = new Code();
        this.teamCode = autoGeneratorCode.getInfo();
    }
    private void setTeamPassword(){
        AutoGenerateTeamCodeInfo autoGeneratorPassword = new Password();
        this.teamPassword = autoGeneratorPassword.getInfo();
    }


}
