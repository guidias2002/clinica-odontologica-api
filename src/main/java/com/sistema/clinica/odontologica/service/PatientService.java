package com.sistema.clinica.odontologica.service;

import com.sistema.clinica.odontologica.domain.PatientEntity;
import com.sistema.clinica.odontologica.dto.PatientDto;
import com.sistema.clinica.odontologica.mapper.PatientMapper;
import com.sistema.clinica.odontologica.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public PatientDto savePatient(PatientDto patientDto) {
        PatientEntity newPatient = patientMapper.toPatientEntity(patientDto);

        newPatient.setCreatedAt(LocalDateTime.now());
        this.patientRepository.save(newPatient);

        return patientMapper.toPatientDto(newPatient);
    }

    public PatientDto findPatientByCpf(String cpf) {
        PatientEntity patient = patientRepository.findPatientByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

        return patientMapper.toPatientDto(patient);
    }
}
