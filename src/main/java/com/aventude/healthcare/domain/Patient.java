package com.aventude.healthcare.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Patient extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

//    @Column(unique = true ,nullable = false)
//    private String nic;

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String contactNo;

    @OneToMany(mappedBy = "patient" , fetch = FetchType.LAZY)
    private List<Consultation> consultations;

    @OneToOne
    private User user;
}
