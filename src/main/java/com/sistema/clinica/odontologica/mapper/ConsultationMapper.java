package com.sistema.clinica.odontologica.mapper;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    //ConsultationMapper INSTANCE = Mappers.getMapper(ConsultationMapper.class);

    ConsultationEntity toConsultationEntity(ConsultationDto consultationDto);
}
