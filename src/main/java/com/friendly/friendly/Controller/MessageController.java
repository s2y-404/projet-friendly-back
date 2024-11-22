package com.friendly.friendly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.friendly.Dto.MessageDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.MessageService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all messages")
    public ResponseEntity<Page<MessageDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(messageService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a message by ID")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) throws ResourceNotFoundException
    {
        return ResponseEntity.ok(messageService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new message")
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        return ResponseEntity.ok(messageService.save(messageDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a message")
    public ResponseEntity<MessageDto> update(@RequestBody MessageDto messageDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(messageService.update(messageDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a message")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
