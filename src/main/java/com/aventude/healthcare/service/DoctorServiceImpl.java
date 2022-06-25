package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.Doctor;
import com.aventude.healthcare.domain.User;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.dto.DoctorDTO;
import com.aventude.healthcare.dto.PatientDTO;
import com.aventude.healthcare.dto.UserDTO;
import com.aventude.healthcare.exception.ConsultationNotFoundException;
import com.aventude.healthcare.exception.DoctorNotFoundException;
import com.aventude.healthcare.exception.PatientNotFoundException;
import com.aventude.healthcare.repository.DoctorRepository;
import com.aventude.healthcare.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements IDoctorService {

  private DoctorRepository doctorRepository;
  private UserRepository userRepository;
  private IHelperService iHelperService;
  private IPatientService iPatientService;
  private IConsultationService iConsultationService;
  private IUserService userService;

  public DoctorServiceImpl(
      DoctorRepository doctorRepository,
      UserRepository userRepository,
      IHelperService iHelperService,
      IPatientService iPatientService,
      IConsultationService iConsultationService,
      IUserService userService) {
    this.doctorRepository = doctorRepository;
    this.userRepository = userRepository;
    this.iHelperService = iHelperService;
    this.iPatientService = iPatientService;
    this.iConsultationService = iConsultationService;
    this.userService = userService;
  }

  @Override
  public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
    UserDTO user = userService.saveUser(doctorDTO.getUser());
    Doctor doctor = iHelperService.map(doctorDTO, Doctor.class);
    doctor.setUser(iHelperService.map(user, User.class));
    return iHelperService.map(doctorRepository.save(doctor), DoctorDTO.class);
  }

  @Override
  public DoctorDTO getDoctor(Long doctorId) throws DoctorNotFoundException {
    return iHelperService.map(
        doctorRepository
            .findById(doctorId)
            .orElseThrow(() -> new DoctorNotFoundException("Doctor not found")),
        DoctorDTO.class);
  }

  @Override
  public DoctorDTO getDoctorByFirstName(String firstName) {
    return null;
  }

  @Override
  public ConsultationDTO consult(ConsultationDTO consultationDTO)
      throws DoctorNotFoundException, PatientNotFoundException {
    Optional<Doctor> doctor =
        Optional.ofNullable(
            doctorRepository
                .findById(consultationDTO.getDoctor().getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not Found")));
    PatientDTO patient;
    if (consultationDTO.getPatient().getPatientId() != null) {
      patient = iPatientService.getPatient(consultationDTO.getPatient().getPatientId());
    } else {
      patient =
          iPatientService.savePatient(
              iHelperService.map(consultationDTO.getPatient(), PatientDTO.class));
    }
    consultationDTO.setDoctor(iHelperService.map(doctor.get(), DoctorDTO.class));
    consultationDTO.setPatient(iHelperService.map(patient, PatientDTO.class));
    return iConsultationService.saveConsultation(consultationDTO);
  }

  @Override
  public List<ConsultationDTO> getAllConsultations(Long doctorId)
      throws ConsultationNotFoundException {
    Optional<Doctor> doctor = doctorRepository.getAllConsultations(doctorId);
    if (doctor.isPresent()) {
      return iHelperService.mapList(doctor.get().getConsultations(), ConsultationDTO.class);
    }
    return null;
  }
}
