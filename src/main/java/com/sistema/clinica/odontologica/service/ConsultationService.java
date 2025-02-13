package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.mapper.ConsultationMapper;
import com.sistema.clinica.odontologica.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationMapper consultationMapper;

    public ConsultationDto saveConsultation(ConsultationDto consultationDto) {
        this.consultationRepository.save(consultationMapper.toConsultationEntity(consultationDto));

        return consultationDto;
    }
}
