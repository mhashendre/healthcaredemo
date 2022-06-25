package com.aventude.healthcare.repository;

import com.aventude.healthcare.domain.Consultation;
import com.aventude.healthcare.domain.Doctor;
import com.aventude.healthcare.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends CrudRepository<Consultation,Long> {

    List<Consultation> getAllByDoctor(Doctor doctor);
    List<Consultation> getAllByPatient(Patient patient);
    List<Consultation> getAllByCreatedDateTimeBetweenAndDoctor(LocalDate startDate ,LocalDate endDate, Doctor doctor);
}
