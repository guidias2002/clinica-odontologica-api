package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

    List<ConsultationEntity> findAllConsultationByPatientCpf(String patientCpf);
}
