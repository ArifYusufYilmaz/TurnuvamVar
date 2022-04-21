package com.turnuvamvar.thesis.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@JsonIgnore
    private Long id;
    @CreatedDate
    //@JsonIgnore
    @Column(name = "created_date")
    private LocalDateTime createDate ;//=LocalDateTime.now();

    @LastModifiedDate
    //@JsonIgnore
    @Column(name = "last_modified_date")
    private LocalDateTime  LastModifiedDate;//=LocalDateTime.now();

    @PrePersist
    protected void onCreate(){
        createDate = LastModifiedDate = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        LastModifiedDate = LocalDateTime.now();
    }
}
