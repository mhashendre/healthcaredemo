package com.aventude.healthcare.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    @CreatedDate
    @Column(name = "createdDateTime")
    private LocalDateTime createdDateTime = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "modifiedDateTime")
    private LocalDateTime modifiedDateTime  = LocalDateTime.now();

    @Column(name = "status")
    private boolean status = true;

    @CreatedBy
    @Column(name = "createdBy")
    private String createdBy;

}
