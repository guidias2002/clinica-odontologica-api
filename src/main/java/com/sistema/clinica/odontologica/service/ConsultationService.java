package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.domain.PatientEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.dto.PatientDto;
import com.sistema.clinica.odontologica.mapper.ConsultationMapper;
import com.sistema.clinica.odontologica.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationMapper consultationMapper;

    @Autowired
    private PatientService patientService;

    public ConsultationDto saveConsultation(ConsultationDto consultationDto) {
        ConsultationEntity newConsultation = consultationMapper.toConsultationEntity(consultationDto);

        newConsultation.setCreatedAt(LocalDateTime.now());
        newConsultation.setUpdatedAt(LocalDateTime.now());

        this.consultationRepository.save(newConsultation);

        return consultationMapper.toConsultationDto(newConsultation);
    }

    public List<ConsultationDto> getAllConsultations() {
        List<ConsultationEntity> consultationEntityList = consultationRepository.findAll();

        return consultationMapper.toConsultationDtoList(consultationEntityList);
    }

    public List<ConsultationDto> getAllConsultationsByPatient(String patientCpf) {
        PatientDto patient = patientService.findPatientByCpf(patientCpf);

        List<ConsultationEntity> consultationEntityList = consultationRepository.findAllConsultationByPatientCpf(patient.cpf());

        return consultationMapper.toConsultationDtoList(consultationEntityList);
    }
}
