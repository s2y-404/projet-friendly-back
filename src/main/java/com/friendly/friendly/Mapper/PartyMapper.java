package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Dto.PartyDto;
import com.friendly.friendly.Dto.TypeDto;
import com.friendly.friendly.Model.Localisation;
import com.friendly.friendly.Model.Party;
import com.friendly.friendly.Model.Type;

@Mapper(componentModel = "spring")
public interface PartyMapper {
    PartyDto toDto(Party party);
    LocalisationDto toLocalisationDto(Localisation localisation);
    TypeDto toTypeDto(Type type);

    Party toEntity(PartyDto partyDto);
    Localisation toLocalisation(LocalisationDto localisationDto);
    Type toType(TypeDto typeDto);
    
    List<PartyDto> toDtos(List<Party> partys);
    List<Party> toEntities(List<PartyDto> partyDtos);
}
