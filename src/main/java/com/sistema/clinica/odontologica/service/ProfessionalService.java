package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.AvailableTimeEntity;
import com.sistema.clinica.odontologica.domain.ProfessionalEntity;
import com.sistema.clinica.odontologica.dto.ProfessionalDto;
import com.sistema.clinica.odontologica.mapper.ProfessionalMapper;
import com.sistema.clinica.odontologica.repository.AvailableTimeRepository;
import com.sistema.clinica.odontologica.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionalMapper professionalMapper;

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    public void saveProfessional(ProfessionalDto professionalDto) {
        ProfessionalEntity newProfessional = professionalRepository.save(professionalMapper.toProfessionalEntity(professionalDto));

        createDefaultSchedule(newProfessional);
    }

    public ProfessionalDto getProfessionalById(Long professionalId) {
        ProfessionalEntity professional = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado."));

        return professionalMapper.toProfessionalDto(professional);
    }



    // metodo para criar horários para os próximos 30 dias
    private void createDefaultSchedule(ProfessionalEntity professional) {
        List<LocalTime> defaultTimes = Arrays.asList(
                LocalTime.of(8, 0), LocalTime.of(9, 0), LocalTime.of(10, 0),
                LocalTime.of(11, 0), LocalTime.of(14, 0), LocalTime.of(15, 0),
                LocalTime.of(16, 0)
        );

        List<AvailableTimeEntity> availableTimes = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (int i = 0; i < 30; i++) {
            LocalDate date = today.plusDays(i);
            for (LocalTime time : defaultTimes) {
                AvailableTimeEntity availableTime = new AvailableTimeEntity();
                availableTime.setProfessionalId(professional.getId());
                availableTime.setDate(date);
                availableTime.setTime(time);
                availableTime.setBooked(false);
                availableTimes.add(availableTime);
            }
        }

        availableTimeRepository.saveAll(availableTimes);
    }
}
