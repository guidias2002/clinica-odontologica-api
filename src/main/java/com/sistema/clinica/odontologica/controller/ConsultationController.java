package com.sistema.clinica.odontologica.controller;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<ConsultationDto> createConsultation(@RequestBody ConsultationDto consultationDto) {

        return new ResponseEntity<>(consultationService.saveConsultation(consultationDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllConsultation")
    public ResponseEntity<List<ConsultationDto>> getAllConsultation() {

        return new ResponseEntity<>(consultationService.getAllConsultations(), HttpStatus.OK);
    }

    @GetMapping("/getAllConsultationByPatientCpf/{patientCpf}")
    public ResponseEntity<List<ConsultationDto>> getAllConsultationByPatientCpf(@PathVariable String patientCpf) {

        return new ResponseEntity<>(consultationService.getAllConsultationsByPatient(patientCpf), HttpStatus.OK);
    }
}
