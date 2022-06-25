package com.aventude.healthcare.controller;

import com.aventude.healthcare.constants.HttpConstants;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.dto.DoctorDTO;
import com.aventude.healthcare.exception.ConsultationNotFoundException;
import com.aventude.healthcare.exception.DoctorNotFoundException;
import com.aventude.healthcare.exception.PatientNotFoundException;
import com.aventude.healthcare.service.IDoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aventude.healthcare.constants.UtilConstants.BASE_API_DOCTOR;

/** This controller handles all the requests related to a Doctor. */
@RestController
@RequestMapping(value = BASE_API_DOCTOR, produces = HttpConstants.APPLICATION_JSON)
public class DoctorController {

  private IDoctorService iDoctorService;

  public DoctorController(IDoctorService iDoctorService) {
    this.iDoctorService = iDoctorService;
  }

  /**
   * Handles new doctor creation requests
   *
   * @param doctorDTO related key values
   * @return response entity.
   */
  @PostMapping(path = "new")
  public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
    return new ResponseEntity<>(iDoctorService.saveDoctor(doctorDTO), HttpStatus.OK);
  }

  /**
   * Handles the fetch requests
   *
   * @param id doctorId (Primary Key)
   * @return response entity
   * @throws DoctorNotFoundException
   */
  @GetMapping(path = "/id/{id}")
  public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) throws DoctorNotFoundException {
    return new ResponseEntity<DoctorDTO>(iDoctorService.getDoctor(id), HttpStatus.OK);
  }

  /**
   * Handles patient consultations
   *
   * @param consultationDTO key values related to the patient.
   * @return response entity.
   * @throws DoctorNotFoundException
   * @throws PatientNotFoundException
   */
  @PostMapping(path = "/consult")
  public ResponseEntity<ConsultationDTO> consult(@RequestBody ConsultationDTO consultationDTO)
      throws DoctorNotFoundException, PatientNotFoundException {
    return new ResponseEntity<ConsultationDTO>(
        iDoctorService.consult(consultationDTO), HttpStatus.OK);
  }

  /**
   * handles reporting related to the consultations.
   *
   * @param doctorId doctor id
   * @return response entity.
   * @throws DoctorNotFoundException
   * @throws ConsultationNotFoundException
   */
  @GetMapping(path = "/patients/doctorId/{doctorId}")
  public ResponseEntity<List<ConsultationDTO>> getAllPatients(@PathVariable Long doctorId)
      throws DoctorNotFoundException, ConsultationNotFoundException {
    return new ResponseEntity<List<ConsultationDTO>>(
        iDoctorService.getAllConsultations(doctorId), HttpStatus.OK);
  }
}
