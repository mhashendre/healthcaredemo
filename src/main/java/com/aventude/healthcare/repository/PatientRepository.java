package com.aventude.healthcare.repository;

import com.aventude.healthcare.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient ,Long> {

    Patient findByFirstName(String firstName);
//    Patient findByNic(String firstName);
}
