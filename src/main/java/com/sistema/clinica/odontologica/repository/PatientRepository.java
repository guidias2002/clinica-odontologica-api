package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    Optional<PatientEntity> findPatientByCpf(String cpf);
}
