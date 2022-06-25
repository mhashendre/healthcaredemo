package com.aventude.healthcare.dto;

import com.aventude.healthcare.domain.Audit;
import com.aventude.healthcare.domain.Doctor;
import com.aventude.healthcare.domain.Patient;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "consultationId")
public class ConsultationDTO extends Audit{

    private Long consultationId;
    private String diagnostics;
    private double bloodPreassure;
    private DoctorDTO doctor;
    private PatientDTO patient;
}
