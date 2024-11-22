package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.friendly.friendly.Dto.TypeDto;
import com.friendly.friendly.Model.Type;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDto toDto(Type type);
    Type toEntity(TypeDto typeDto);
    List<TypeDto> toDtos(List<Type> types);
    List<Type> toEntities(List<TypeDto> typeDtos);
}
