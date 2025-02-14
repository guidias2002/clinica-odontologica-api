package com.sistema.clinica.odontologica.mapper;

import com.sistema.clinica.odontologica.domain.AvailableTimeEntity;
import com.sistema.clinica.odontologica.dto.AvailableTimeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailableTimeMapper {

    AvailableTimeDto toAvailableTimeDto(AvailableTimeEntity availableTimeEntity);
}
