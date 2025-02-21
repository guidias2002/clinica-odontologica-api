package com.sistema.clinica.odontologica.controller;

import com.sistema.clinica.odontologica.dto.ProfessionalBasicInfoDto;
import com.sistema.clinica.odontologica.dto.ProfessionalDto;
import com.sistema.clinica.odontologica.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping
    public ResponseEntity<Void> createProfessional(@RequestBody ProfessionalDto professionalDto) {
        professionalService.saveProfessional(professionalDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getProfessionalById/{professionalId}")
    public ResponseEntity<ProfessionalDto> getProfessionalById(@PathVariable Long professionalId) {

        return new ResponseEntity<>(professionalService.getProfessionalById(professionalId), HttpStatus.OK);
    }

    @GetMapping("/getAllProfessional")
    public ResponseEntity<List<ProfessionalBasicInfoDto>> getAllProfessionals() {

        return new ResponseEntity<>(professionalService.getAllProfessionals(), HttpStatus.OK);
    }
}
