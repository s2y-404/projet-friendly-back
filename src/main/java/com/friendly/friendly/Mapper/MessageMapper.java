package com.friendly.friendly.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.friendly.friendly.Dto.MessageDto;
import com.friendly.friendly.Model.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {   
    MessageDto toDto(Message message);
    Message toEntity(MessageDto messageDto);    
    List<MessageDto> toDtos(List<Message> messages);
    List<Message> toEntities(List<MessageDto> messageDtos);
}
