package com.aventude.healthcare.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true ,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
