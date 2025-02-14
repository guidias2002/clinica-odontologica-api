package com.sistema.clinica.odontologica.dto;

import com.sistema.clinica.odontologica.domain.AvailableTimeEntity;

import java.util.List;

public record ProfessionalDto(Long id, String name, String email, List<AvailableTimeEntity> availableTimes) {
}
