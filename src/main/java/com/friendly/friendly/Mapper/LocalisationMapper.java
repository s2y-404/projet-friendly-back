package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Model.Localisation;

@Mapper(componentModel = "spring")
public interface LocalisationMapper {
    LocalisationMapper INSTANCE = Mappers.getMapper(LocalisationMapper.class);

    LocalisationDto toDto(Localisation localisation);
    Localisation toEntity(LocalisationDto localisationDto);
    List<LocalisationDto> toDtos(List<Localisation> localisations);
    List<Localisation> toEntities(List<LocalisationDto> localisationDtos);
}
