package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Dto.UserDto;
import com.friendly.friendly.Model.Hobby;
import com.friendly.friendly.Model.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T16:13:02+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setBirthdate( user.getBirthdate() );
        userDto.setHobbies( hobbySetToHobbyDtoList( user.getHobbies() ) );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setBirthdate( userDto.getBirthdate() );
        user.setHobbies( hobbyDtoListToHobbySet( userDto.getHobbies() ) );

        return user;
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntities(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public HobbyDto toHobbyDto(Hobby hobby) {
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
    public Hobby toHobbyEntity(HobbyDto hobbyDto) {
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
    public Set<HobbyDto> toHobbyDtos(Set<Hobby> hobbies) {
        if ( hobbies == null ) {
            return null;
        }

        Set<HobbyDto> set = new LinkedHashSet<HobbyDto>( Math.max( (int) ( hobbies.size() / .75f ) + 1, 16 ) );
        for ( Hobby hobby : hobbies ) {
            set.add( toHobbyDto( hobby ) );
        }

        return set;
    }

    @Override
    public Set<Hobby> toHobbyEntities(Set<HobbyDto> hobbyDtos) {
        if ( hobbyDtos == null ) {
            return null;
        }

        Set<Hobby> set = new LinkedHashSet<Hobby>( Math.max( (int) ( hobbyDtos.size() / .75f ) + 1, 16 ) );
        for ( HobbyDto hobbyDto : hobbyDtos ) {
            set.add( toHobbyEntity( hobbyDto ) );
        }

        return set;
    }

    protected List<HobbyDto> hobbySetToHobbyDtoList(Set<Hobby> set) {
        if ( set == null ) {
            return null;
        }

        List<HobbyDto> list = new ArrayList<HobbyDto>( set.size() );
        for ( Hobby hobby : set ) {
            list.add( toHobbyDto( hobby ) );
        }

        return list;
    }

    protected Set<Hobby> hobbyDtoListToHobbySet(List<HobbyDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<Hobby> set = new LinkedHashSet<Hobby>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( HobbyDto hobbyDto : list ) {
            set.add( toHobbyEntity( hobbyDto ) );
        }

        return set;
    }
}
