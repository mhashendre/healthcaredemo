package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.Patient;
import com.aventude.healthcare.domain.User;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.dto.PatientDTO;
import com.aventude.healthcare.dto.UserDTO;
import com.aventude.healthcare.exception.PatientNotFoundException;
import com.aventude.healthcare.repository.PatientRepository;
import com.aventude.healthcare.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

  private PatientRepository patientRepository;
  private UserRepository userRepository;
  private IHelperService iHelperService;
  private IUserService userService;

  public PatientServiceImpl(
      PatientRepository patientRepository,
      UserRepository userRepository,
      IHelperService iHelperService,
      IUserService userService) {
    this.patientRepository = patientRepository;
    this.userRepository = userRepository;
    this.iHelperService = iHelperService;
    this.userService = userService;
  }

  @Override
  public PatientDTO savePatient(PatientDTO patientDTO) {
    UserDTO user = userService.saveUser(patientDTO.getUser());
    Patient patient = iHelperService.map(patientDTO, Patient.class);
    patient.setUser(iHelperService.map(user, User.class));
    return iHelperService.map(patientRepository.save(patient), PatientDTO.class);
  }

  @Override
  public PatientDTO getPatient(Long patientId) throws PatientNotFoundException {
    return iHelperService.map(
        patientRepository
            .findById(patientId)
            .orElseThrow(() -> new PatientNotFoundException("Patient not found")),
        PatientDTO.class);
  }

  @Override
  public List<ConsultationDTO> getConsultations(Long patientId) throws PatientNotFoundException {
    PatientDTO patientDTO = getPatient(patientId);
    return patientDTO.getConsultations();
  }
}
