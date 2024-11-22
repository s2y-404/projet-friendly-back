package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Model.Hobby;

@Mapper(componentModel = "spring")
public interface HobbyMapper {
    HobbyDto toDto(Hobby hobby);
    Hobby toEntity(HobbyDto hobbyDto);
    List<HobbyDto> toDtos(List<Hobby> hobbys);
    List<Hobby> toEntities(List<HobbyDto> hobbyDtos);
}
