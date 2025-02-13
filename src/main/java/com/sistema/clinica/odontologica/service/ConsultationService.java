package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.mapper.ConsultationMapper;
import com.sistema.clinica.odontologica.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationMapper consultationMapper;

    public ConsultationDto saveConsultation(ConsultationDto consultationDto) {
        ConsultationEntity newConsultation = consultationMapper.toConsultationEntity(consultationDto);

        newConsultation.setCreatedAt(LocalDateTime.now());
        newConsultation.setUpdatedAt(LocalDateTime.now());

        this.consultationRepository.save(newConsultation);

        return consultationMapper.toConsultationDto(newConsultation);
    }
}
