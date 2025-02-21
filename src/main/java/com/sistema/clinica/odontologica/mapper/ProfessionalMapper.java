package com.sistema.clinica.odontologica.mapper;

import com.sistema.clinica.odontologica.domain.ProfessionalEntity;
import com.sistema.clinica.odontologica.dto.ProfessionalBasicInfoDto;
import com.sistema.clinica.odontologica.dto.ProfessionalDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    ProfessionalEntity toProfessionalEntity(ProfessionalDto professionalDto);

    ProfessionalDto toProfessionalDto(ProfessionalEntity professionalEntity);

    List<ProfessionalBasicInfoDto> toProfessionalBasicInfoDtoList(List<ProfessionalEntity> professionalEntityList);
}
