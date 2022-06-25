package com.aventude.healthcare.controller;

import com.aventude.healthcare.constants.HttpConstants;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.exception.PatientNotFoundException;
import com.aventude.healthcare.service.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aventude.healthcare.constants.UtilConstants.BASE_API_PATIENT;

/** THis controller handles all the requests related to a patient. */
@RestController
@RequestMapping(value = BASE_API_PATIENT, produces = HttpConstants.APPLICATION_JSON)
public class PatientController {

  private IPatientService iPatientService;

  public PatientController(IPatientService iPatientService) {
    this.iPatientService = iPatientService;
  }

  /**
   * Handles the reporting related to the consultations.
   *
   * @param patientId patientID
   * @return response entity.
   * @throws PatientNotFoundException
   */
  @GetMapping(path = "/consultations/patientId/{patientId}")
  public ResponseEntity<List<ConsultationDTO>> getAllConsultations(@PathVariable Long patientId)
      throws PatientNotFoundException {
    return new ResponseEntity<List<ConsultationDTO>>(
        iPatientService.getConsultations(patientId), HttpStatus.OK);
  }
}
