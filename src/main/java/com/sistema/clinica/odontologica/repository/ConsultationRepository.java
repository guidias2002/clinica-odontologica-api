package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.domain.ConsultationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

    List<ConsultationEntity> findAllConsultationByPatientCpf(String patientCpf);

    List<ConsultationEntity> findAllConsultationByStatus(ConsultationStatus status);

    List<ConsultationEntity> findByProfessionalIdAndConsultationDate(Long professionalId, LocalDate date);
}
