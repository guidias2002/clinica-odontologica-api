package com.sistema.clinica.odontologica.dto;

import com.sistema.clinica.odontologica.domain.ConsultationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ConsultationDto(
        String patientName,
        String patientEmail,
        String patientCellphone,
        String patientCpf,
        Long professionalId,
        String professionalName,
        Long availableTimeId,
        LocalDate consultationDate,
        LocalTime consultationTime,
        String consultationType,
        int estimatedDuration,
        ConsultationStatus status,
        String observations,
        BigDecimal consultationValue,
        String paymentMethod,
        String paymentStatus,
        boolean notificationSent,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
