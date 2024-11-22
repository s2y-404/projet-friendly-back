package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Model.Localisation;
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
public class LocalisationMapperImpl implements LocalisationMapper {

    @Override
    public LocalisationDto toDto(Localisation localisation) {
        if ( localisation == null ) {
            return null;
        }

        LocalisationDto localisationDto = new LocalisationDto();

        localisationDto.setId( localisation.getId() );
        localisationDto.setAddress( localisation.getAddress() );
        localisationDto.setCity( localisation.getCity() );
        localisationDto.setCountry( localisation.getCountry() );

        return localisationDto;
    }

    @Override
    public Localisation toEntity(LocalisationDto localisationDto) {
        if ( localisationDto == null ) {
            return null;
        }

        Localisation localisation = new Localisation();

        localisation.setId( localisationDto.getId() );
        localisation.setAddress( localisationDto.getAddress() );
        localisation.setCity( localisationDto.getCity() );
        localisation.setCountry( localisationDto.getCountry() );

        return localisation;
    }

    @Override
    public List<LocalisationDto> toDtos(List<Localisation> localisations) {
        if ( localisations == null ) {
            return null;
        }

        List<LocalisationDto> list = new ArrayList<LocalisationDto>( localisations.size() );
        for ( Localisation localisation : localisations ) {
            list.add( toDto( localisation ) );
        }

        return list;
    }

    @Override
    public List<Localisation> toEntities(List<LocalisationDto> localisationDtos) {
        if ( localisationDtos == null ) {
            return null;
        }

        List<Localisation> list = new ArrayList<Localisation>( localisationDtos.size() );
        for ( LocalisationDto localisationDto : localisationDtos ) {
            list.add( toEntity( localisationDto ) );
        }

        return list;
    }
}
