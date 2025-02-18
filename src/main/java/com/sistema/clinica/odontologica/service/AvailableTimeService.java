package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.AvailableTimeEntity;
import com.sistema.clinica.odontologica.domain.ProfessionalEntity;
import com.sistema.clinica.odontologica.dto.AvailableTimeDto;
import com.sistema.clinica.odontologica.mapper.AvailableTimeMapper;
import com.sistema.clinica.odontologica.mapper.ProfessionalMapper;
import com.sistema.clinica.odontologica.repository.AvailableTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableTimeService {

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @Autowired
    private AvailableTimeMapper availableTimeMapper;

    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private ProfessionalMapper professionalMapper;

    public List<String> getAvailableTimes(Long professionalId, LocalDate date) {
        List<AvailableTimeEntity> availableTimes = availableTimeRepository
                .findByProfessionalIdAndDateAndBookedFalse(professionalId, date);

        return availableTimes.stream()
                .map(time -> time.getTime().toString()) // retorna a String do horário
                .collect(Collectors.toList());
    }

    public void reserveTime(Long professionalId, Long availableTimeId) {
        professionalMapper.toProfessionalEntity(professionalService.getProfessionalById(professionalId));

        // retorna um availableTimeEntity pela data e hora enviada
        // VERIFICA POSSIBILIDADE DE ALTERAR PARA PROCURAR PELO ID DO HORARIO
        AvailableTimeEntity availableTimeEntity = availableTimeRepository.findById(availableTimeId)
                .orElseThrow(() -> new RuntimeException("Data de marcação não encontrada."));

        if(availableTimeEntity.isBooked()) {
            throw new RuntimeException("Esse horário já foi reservado.");
        }

        availableTimeEntity.setBooked(true);
        availableTimeRepository.save(availableTimeEntity);
    }

    public List<AvailableTimeDto> getProfessionalHoursPerDay(Long professionalId, LocalDate date) {
        professionalMapper.toProfessionalEntity(professionalService.getProfessionalById(professionalId));

        return availableTimeMapper.toAvailableTimeListDto(availableTimeRepository.findByProfessionalIdAndDate(professionalId, date));
    }

}
