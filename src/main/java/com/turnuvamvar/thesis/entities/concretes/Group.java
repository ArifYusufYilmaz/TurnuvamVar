package com.turnuvamvar.thesis.entities.concretes;

import com.turnuvamvar.thesis.entities.abstracts.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="groups")*/
@Data
public class Group extends BaseEntity { // description ekleyebilirsin..
    private String groupName;
    // private  oynanan maç sayısı
    // galibiyet
    //beraberlik
    //mağlubiyet
}
