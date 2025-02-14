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

    @ManyToOne
    @JoinColumn(name = "professional_id", nullable = false)
    @JsonBackReference
    private ProfessionalEntity professional;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private boolean booked = false;

    public AvailableTimeEntity(ProfessionalEntity professional, LocalDate date, LocalTime time, boolean booked) {
        this.professional = professional;
        this.date = date;
        this.time = time;
        this.booked = booked;
    }
}
