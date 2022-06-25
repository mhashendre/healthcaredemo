package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.Consultation;
import com.aventude.healthcare.dto.ConsultationDTO;
import com.aventude.healthcare.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationServiceImpl implements IConsultationService {

  private ConsultationRepository consultationRepository;
  private IHelperService iHelperService;

  public ConsultationServiceImpl(
      ConsultationRepository consultationRepository, IHelperService iHelperService) {
    this.consultationRepository = consultationRepository;
    this.iHelperService = iHelperService;
  }

  @Override
  public ConsultationDTO saveConsultation(ConsultationDTO consultationDTO) {
    return iHelperService.map(
        consultationRepository.save(iHelperService.map(consultationDTO, Consultation.class)),
        ConsultationDTO.class);
  }
}
