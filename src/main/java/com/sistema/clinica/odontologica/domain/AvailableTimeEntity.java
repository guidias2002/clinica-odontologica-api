package com.sistema.clinica.odontologica.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "available_times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long professionalId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private boolean booked = false;

    public AvailableTimeEntity(Long professionalId, LocalDate date, LocalTime time, boolean booked) {
        this.professionalId = professionalId;
        this.date = date;
        this.time = time;
        this.booked = booked;
    }
}
