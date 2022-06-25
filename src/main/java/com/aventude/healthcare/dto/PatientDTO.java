package com.aventude.healthcare.dto;

import com.aventude.healthcare.domain.Audit;
import com.aventude.healthcare.domain.Consultation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "patientId")
public class PatientDTO extends Audit {

    private Long patientId;
    private String nic;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String contactNo;
    private List<ConsultationDTO> consultations;
    private UserDTO user;
}
