package com.sistema.clinica.odontologica.controller;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import com.sistema.clinica.odontologica.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<ConsultationDto> createConsultation(@RequestBody ConsultationDto consultationDto) {

        return new ResponseEntity<>(consultationService.saveConsultation(consultationDto), HttpStatus.CREATED);
    }
}
