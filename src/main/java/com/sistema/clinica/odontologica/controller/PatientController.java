package com.sistema.clinica.odontologica.controller;

import com.sistema.clinica.odontologica.dto.PatientDto;
import com.sistema.clinica.odontologica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {

        return new ResponseEntity<>(patientService.savePatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping("/getPatientByCpf/{cpfPatient}")
    public ResponseEntity<PatientDto> findPatientByCpf(@PathVariable String cpfPatient) {

        return new ResponseEntity<>(patientService.findPatientByCpf(cpfPatient), HttpStatus.OK);
    }
}
