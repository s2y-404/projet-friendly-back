package com.friendly.friendly.Mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Dto.UserDto;
import com.friendly.friendly.Model.Hobby;
import com.friendly.friendly.Model.User;
    
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);
    
    HobbyDto toHobbyDto(Hobby hobby);
    Hobby toHobbyEntity(HobbyDto hobbyDto);
    Set<HobbyDto> toHobbyDtos(Set<Hobby> hobbies);
    Set<Hobby> toHobbyEntities(Set<HobbyDto> hobbyDtos);
}
