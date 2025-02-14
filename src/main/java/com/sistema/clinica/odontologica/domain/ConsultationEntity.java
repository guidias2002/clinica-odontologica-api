package com.sistema.clinica.odontologica.domain;

import com.sistema.clinica.odontologica.dto.ConsultationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patientName;
    private String patientEmail;
    private String patientCellphone;
    private String patientCpf;
    private Long professionalId;
    private String professionalName;
    private LocalDate consultationDate;
    private LocalTime consultationTime;
    private String consultationType;
    private int estimatedDuration;

    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;
    private String observations;
    private BigDecimal consultationValue;
    private String paymentMethod;
    private String paymentStatus;
    private boolean notificationSent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
