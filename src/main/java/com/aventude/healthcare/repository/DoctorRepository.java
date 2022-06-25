package com.aventude.healthcare.repository;

import com.aventude.healthcare.domain.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

  Doctor findByFirstName(String firstName);

  @Query(
      nativeQuery = true,
      value =
          "Select * from doctor d inner join consultation c on d.doctor_id = c.doctor_id where d.doctor_id = ?1")
  Optional<Doctor> getAllConsultations(Long doctorId);
}
