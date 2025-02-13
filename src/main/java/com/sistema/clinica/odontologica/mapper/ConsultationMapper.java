package com.sistema.clinica.odontologica.mapper;

import com.sistema.clinica.odontologica.domain.ConsultationEntity;
import com.sistema.clinica.odontologica.dto.ConsultationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    ConsultationEntity toConsultationEntity(ConsultationDto consultationDto);

    ConsultationDto toConsultationDto(ConsultationEntity consultationEntity);

    List<ConsultationDto> toConsultationDtoList(List<ConsultationEntity> consultationEntityList);
}
