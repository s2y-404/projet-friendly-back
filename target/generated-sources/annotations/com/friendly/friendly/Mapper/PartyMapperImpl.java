package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Dto.PartyDto;
import com.friendly.friendly.Dto.TypeDto;
import com.friendly.friendly.Model.Localisation;
import com.friendly.friendly.Model.Party;
import com.friendly.friendly.Model.Type;
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
public class PartyMapperImpl implements PartyMapper {

    @Override
    public PartyDto toDto(Party party) {
        if ( party == null ) {
            return null;
        }

        PartyDto partyDto = new PartyDto();

        partyDto.setId( party.getId() );
        partyDto.setName( party.getName() );
        partyDto.setDescription( party.getDescription() );
        partyDto.setDate( party.getDate() );
        partyDto.setNbPlace( party.getNbPlace() );
        partyDto.setIsPaying( party.getIsPaying() );
        partyDto.setPrice( party.getPrice() );
        partyDto.setType( toTypeDto( party.getType() ) );

        return partyDto;
    }

    @Override
    public LocalisationDto toLocalisationDto(Localisation localisation) {
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
    public TypeDto toTypeDto(Type type) {
        if ( type == null ) {
            return null;
        }

        TypeDto typeDto = new TypeDto();

        typeDto.setId( type.getId() );
        typeDto.setLabel( type.getLabel() );
        typeDto.setDescription( type.getDescription() );

        return typeDto;
    }

    @Override
    public Party toEntity(PartyDto partyDto) {
        if ( partyDto == null ) {
            return null;
        }

        Party party = new Party();

        party.setId( partyDto.getId() );
        party.setName( partyDto.getName() );
        party.setDescription( partyDto.getDescription() );
        party.setDate( partyDto.getDate() );
        party.setNbPlace( partyDto.getNbPlace() );
        party.setIsPaying( partyDto.getIsPaying() );
        party.setPrice( partyDto.getPrice() );
        party.setType( toType( partyDto.getType() ) );

        return party;
    }

    @Override
    public Localisation toLocalisation(LocalisationDto localisationDto) {
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
    public Type toType(TypeDto typeDto) {
        if ( typeDto == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( typeDto.getId() );
        type.setLabel( typeDto.getLabel() );
        type.setDescription( typeDto.getDescription() );

        return type;
    }

    @Override
    public List<PartyDto> toDtos(List<Party> partys) {
        if ( partys == null ) {
            return null;
        }

        List<PartyDto> list = new ArrayList<PartyDto>( partys.size() );
        for ( Party party : partys ) {
            list.add( toDto( party ) );
        }

        return list;
    }

    @Override
    public List<Party> toEntities(List<PartyDto> partyDtos) {
        if ( partyDtos == null ) {
            return null;
        }

        List<Party> list = new ArrayList<Party>( partyDtos.size() );
        for ( PartyDto partyDto : partyDtos ) {
            list.add( toEntity( partyDto ) );
        }

        return list;
    }
}
