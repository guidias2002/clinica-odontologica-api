package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.domain.ConsultationStatus;
import com.sistema.clinica.odontologica.domain.PatientEntity;
import com.sistema.clinica.odontologica.domain.ProfessionalEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.dto.PatientDto;
import com.sistema.clinica.odontologica.dto.ProfessionalDto;
import com.sistema.clinica.odontologica.mapper.ConsultationMapper;
import com.sistema.clinica.odontologica.mapper.ProfessionalMapper;
import com.sistema.clinica.odontologica.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    private AvailableTimeService availableTimeService;

    public ConsultationDto saveConsultation(ConsultationDto consultationDto) {
        ConsultationEntity newConsultation = consultationMapper.toConsultationEntity(consultationDto);

        availableTimeService.reserveTime(consultationDto.professionalId(), consultationDto.consultationDate(), consultationDto.consultationTime());

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

    public List<ConsultationDto> getAllConsultationsByStatus(ConsultationStatus status) {
        List<ConsultationEntity> consultationEntityList = consultationRepository.findAllConsultationByStatus(status);

        return consultationMapper.toConsultationDtoList(consultationEntityList);
    }

    public List<ConsultationDto> getProfessionalDayAppointments(Long professionalId) {

        return consultationMapper.toConsultationDtoList(consultationRepository.findByProfessionalIdAndConsultationDate(professionalId, LocalDate.now()));
    }
}
