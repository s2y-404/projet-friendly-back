package com.friendly.friendly.Mapper;

import com.friendly.friendly.Dto.MessageDto;
import com.friendly.friendly.Model.Message;
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
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageDto toDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setId( message.getId() );
        messageDto.setContent( message.getContent() );

        return messageDto;
    }

    @Override
    public Message toEntity(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( messageDto.getId() );
        message.setContent( messageDto.getContent() );

        return message;
    }

    @Override
    public List<MessageDto> toDtos(List<Message> messages) {
        if ( messages == null ) {
            return null;
        }

        List<MessageDto> list = new ArrayList<MessageDto>( messages.size() );
        for ( Message message : messages ) {
            list.add( toDto( message ) );
        }

        return list;
    }

    @Override
    public List<Message> toEntities(List<MessageDto> messageDtos) {
        if ( messageDtos == null ) {
            return null;
        }

        List<Message> list = new ArrayList<Message>( messageDtos.size() );
        for ( MessageDto messageDto : messageDtos ) {
            list.add( toEntity( messageDto ) );
        }

        return list;
    }
}
