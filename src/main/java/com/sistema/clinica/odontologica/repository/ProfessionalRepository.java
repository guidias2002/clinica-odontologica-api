package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
}
