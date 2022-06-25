package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.Doctor;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.dto.DoctorDTO;
import com.aventude.healthcare.exception.ConsultationNotFoundException;
import com.aventude.healthcare.exception.DoctorNotFoundException;
import com.aventude.healthcare.exception.PatientNotFoundException;

import java.util.List;

public interface IDoctorService {

    DoctorDTO saveDoctor(DoctorDTO doctorDTO);
    DoctorDTO getDoctor(Long doctorId) throws DoctorNotFoundException;
    DoctorDTO getDoctorByFirstName(String firstName);

    ConsultationDTO consult(ConsultationDTO consultationDTO)
            throws DoctorNotFoundException, PatientNotFoundException;

    List<ConsultationDTO> getAllConsultations(Long doctorId) throws ConsultationNotFoundException;
}
