package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.ScoreDto;
import com.friendly.friendly.Model.Score;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T16:13:02+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public ScoreDto toDto(Score score) {
        if ( score == null ) {
            return null;
        }

        ScoreDto scoreDto = new ScoreDto();

        scoreDto.setId( score.getId() );
        scoreDto.setNbStar( score.getNbStar() );
        scoreDto.setRemark( score.getRemark() );

        return scoreDto;
    }

    @Override
    public Score toEntity(ScoreDto scoreDto) {
        if ( scoreDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scoreDto.getId() );
        score.setNbStar( scoreDto.getNbStar() );
        score.setRemark( scoreDto.getRemark() );

        return score;
    }

    @Override
    public List<ScoreDto> toDtos(List<Score> scores) {
        if ( scores == null ) {
            return null;
        }

        List<ScoreDto> list = new ArrayList<ScoreDto>( scores.size() );
        for ( Score score : scores ) {
            list.add( toDto( score ) );
        }

        return list;
    }

    @Override
    public List<Score> toEntities(List<ScoreDto> scoreDtos) {
        if ( scoreDtos == null ) {
            return null;
        }

        List<Score> list = new ArrayList<Score>( scoreDtos.size() );
        for ( ScoreDto scoreDto : scoreDtos ) {
            list.add( toEntity( scoreDto ) );
        }

        return list;
    }
}
