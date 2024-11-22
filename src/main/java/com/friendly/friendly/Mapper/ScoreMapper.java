package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.friendly.friendly.Dto.ScoreDto;
import com.friendly.friendly.Model.Score;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    ScoreMapper INSTANCE = Mappers.getMapper(ScoreMapper.class);

    ScoreDto toDto(Score score);
    Score toEntity(ScoreDto scoreDto);
    List<ScoreDto> toDtos(List<Score> scores);
    List<Score> toEntities(List<ScoreDto> scoreDtos);
}
