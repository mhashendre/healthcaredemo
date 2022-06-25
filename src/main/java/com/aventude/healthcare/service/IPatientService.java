package com.aventude.healthcare.service;

import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.dto.PatientDTO;
import com.aventude.healthcare.exception.ConsultationNotFoundException;
import com.aventude.healthcare.exception.PatientNotFoundException;

import java.util.List;

public interface IPatientService {
    PatientDTO savePatient(PatientDTO patientDTO);

    PatientDTO getPatient(Long patientId) throws PatientNotFoundException;
    List<ConsultationDTO> getConsultations(Long patientId) throws PatientNotFoundException;
}
