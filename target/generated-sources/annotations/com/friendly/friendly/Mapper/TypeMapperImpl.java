package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.TypeDto;
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
public class TypeMapperImpl implements TypeMapper {

    @Override
    public TypeDto toDto(Type type) {
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
    public Type toEntity(TypeDto typeDto) {
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
    public List<TypeDto> toDtos(List<Type> types) {
        if ( types == null ) {
            return null;
        }

        List<TypeDto> list = new ArrayList<TypeDto>( types.size() );
        for ( Type type : types ) {
            list.add( toDto( type ) );
        }

        return list;
    }

    @Override
    public List<Type> toEntities(List<TypeDto> typeDtos) {
        if ( typeDtos == null ) {
            return null;
        }

        List<Type> list = new ArrayList<Type>( typeDtos.size() );
        for ( TypeDto typeDto : typeDtos ) {
            list.add( toEntity( typeDto ) );
        }

        return list;
    }
}
