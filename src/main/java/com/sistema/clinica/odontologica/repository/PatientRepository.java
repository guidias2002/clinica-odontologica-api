package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    Optional<PatientEntity> findPatientByCpf(String cpf);
}
