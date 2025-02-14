package com.sistema.clinica.odontologica.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailableTimeDto(Long id, Long professionalId, LocalDate date, LocalTime time, boolean booked) {
}
