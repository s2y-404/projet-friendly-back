package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Model.Hobby;
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
public class HobbyMapperImpl implements HobbyMapper {

    @Override
    public HobbyDto toDto(Hobby hobby) {
        if ( hobby == null ) {
            return null;
        }

        HobbyDto hobbyDto = new HobbyDto();

        hobbyDto.setId( hobby.getId() );
        hobbyDto.setLabel( hobby.getLabel() );
        hobbyDto.setDescription( hobby.getDescription() );

        return hobbyDto;
    }

    @Override
    public Hobby toEntity(HobbyDto hobbyDto) {
        if ( hobbyDto == null ) {
            return null;
        }

        Hobby hobby = new Hobby();

        hobby.setId( hobbyDto.getId() );
        hobby.setLabel( hobbyDto.getLabel() );
        hobby.setDescription( hobbyDto.getDescription() );

        return hobby;
    }

    @Override
    public List<HobbyDto> toDtos(List<Hobby> hobbys) {
        if ( hobbys == null ) {
            return null;
        }

        List<HobbyDto> list = new ArrayList<HobbyDto>( hobbys.size() );
        for ( Hobby hobby : hobbys ) {
            list.add( toDto( hobby ) );
        }

        return list;
    }

    @Override
    public List<Hobby> toEntities(List<HobbyDto> hobbyDtos) {
        if ( hobbyDtos == null ) {
            return null;
        }

        List<Hobby> list = new ArrayList<Hobby>( hobbyDtos.size() );
        for ( HobbyDto hobbyDto : hobbyDtos ) {
            list.add( toEntity( hobbyDto ) );
        }

        return list;
    }
}
