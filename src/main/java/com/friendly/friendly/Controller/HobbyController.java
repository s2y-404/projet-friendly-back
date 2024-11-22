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

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.HobbyService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
    
    @Autowired
    private HobbyService hobbyService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all hobbys")
    public ResponseEntity<Page<HobbyDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(hobbyService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a hobby by ID")
    public ResponseEntity<HobbyDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(hobbyService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new hobby")
    public ResponseEntity<HobbyDto> save(@RequestBody HobbyDto hobbyDto) {
        return ResponseEntity.ok(hobbyService.save(hobbyDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a hobby")
    public ResponseEntity<HobbyDto> update(@RequestBody HobbyDto hobbyDto) {
        return ResponseEntity.ok(hobbyService.update(hobbyDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a hobby")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hobbyService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
