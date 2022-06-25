package com.aventude.healthcare.dto;

import com.aventude.healthcare.domain.Audit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "doctorId")
public class DoctorDTO extends Audit {

    private Long doctorId;

    private String firstName;
    private String lastName;
    private String contactNo;
    private UserDTO user;
    private List<ConsultationDTO> consultations;
}
