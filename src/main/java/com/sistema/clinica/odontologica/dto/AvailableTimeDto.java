package com.sistema.clinica.odontologica.dto;

import com.sistema.clinica.odontologica.domain.ProfessionalEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailableTimeDto(ProfessionalEntity professionl, LocalDate date, LocalTime time, boolean booked) {
}
