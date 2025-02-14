package com.sistema.clinica.odontologica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "professionalId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailableTimeEntity> availableTimes = new ArrayList<>();
}

