package com.sistema.clinica.odontologica.dto;

import com.sistema.clinica.odontologica.domain.ConsultationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultationDto(
        String patientName,
        String patientEmail,
        String patientCellphone,
        String patientDocument,
        String dentistName,
        LocalDateTime consultationDate,
        String consultationType,
        int estimatedDuration,
        ConsultationStatus consultationStatus,
        String observations,
        BigDecimal consultationValue,
        String paymentMethod,
        String paymentStatus,
        boolean notificationSent,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
