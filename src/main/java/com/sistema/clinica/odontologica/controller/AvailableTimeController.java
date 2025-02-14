package com.sistema.clinica.odontologica.controller;

import com.sistema.clinica.odontologica.dto.AvailableTimeDto;
import com.sistema.clinica.odontologica.service.AvailableTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/availableTime")
public class AvailableTimeController {

    @Autowired
    private AvailableTimeService availableTimeService;

    @GetMapping("/getProfessionalHoursPerDay/{professionalId}/{date}")
    public ResponseEntity<List<AvailableTimeDto>> getProfessionalHoursPerDay(@PathVariable Long professionalId, @PathVariable LocalDate date) {

        return new ResponseEntity<>(availableTimeService.getProfessionalHoursPerDay(professionalId, date), HttpStatus.OK);
    }
}
