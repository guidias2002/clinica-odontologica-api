package com.sistema.clinica.odontologica.repository;

import com.sistema.clinica.odontologica.domain.AvailableTimeEntity;
import com.sistema.clinica.odontologica.dto.AvailableTimeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AvailableTimeRepository extends JpaRepository<AvailableTimeEntity, Long> {

    List<AvailableTimeEntity> findByProfessionalIdAndDateAndBookedFalse(Long professionalId, LocalDate date);

    List<AvailableTimeEntity> findByProfessionalIdAndDate(Long professionalId, LocalDate date);

    AvailableTimeEntity findByDateAndTimeAndProfessionalId(LocalDate date, LocalTime time, Long professionalId);
}
