package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.MessageDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.MessageMapper;
import com.friendly.friendly.Model.Message;
import com.friendly.friendly.Repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private MessageMapper messageMapper;

    public Page<MessageDto> findAll(int page, int size) {
        return messageRepository
                .findAll(PageRequest.of(page, size))
                .map(messageMapper::toDto);
    }

    public MessageDto findById(long id) throws ResourceNotFoundException {
        Message message = messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found"));
        return messageMapper.toDto(message);
    }

    public MessageDto save(MessageDto messageDto) {
        Message message = messageMapper.toEntity(messageDto);
        return messageMapper.toDto(messageRepository.save(message));
    }

    public MessageDto update(MessageDto messageDto) throws ResourceNotFoundException {
        messageRepository.findById(messageDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Message not found"));

        Message updatedMessage = messageMapper.toEntity(messageDto);
        return messageMapper.toDto(messageRepository.save(updatedMessage));
    }

    public void delete(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new ResourceNotFoundException("Message with ID " + id + " does not exist.");
        }
        messageRepository.deleteById(id);
    }
}
