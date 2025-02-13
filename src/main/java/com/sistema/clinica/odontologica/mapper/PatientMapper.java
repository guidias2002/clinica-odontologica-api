package com.sistema.clinica.odontologica.mapper;

import com.sistema.clinica.odontologica.domain.PatientEntity;
import com.sistema.clinica.odontologica.dto.PatientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientEntity toPatientEntity(PatientDto patientDto);
    PatientDto toPatientDto(PatientEntity patientEntity);


}
