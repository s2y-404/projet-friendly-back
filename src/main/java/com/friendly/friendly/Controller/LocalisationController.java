package com.friendly.friendly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.LocalisationService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/localisation")
public class LocalisationController {
    
    @Autowired
    private LocalisationService localisationService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all localisations")
    public ResponseEntity<Page<LocalisationDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(localisationService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a localisation by ID")
    public ResponseEntity<LocalisationDto> findById(@PathVariable Long id) throws ResourceNotFoundException
    {
        return ResponseEntity.ok(localisationService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new localisation")
    public ResponseEntity<LocalisationDto> save(@RequestBody LocalisationDto localisationDto) {
        return ResponseEntity.ok(localisationService.save(localisationDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a localisation")
    public ResponseEntity<LocalisationDto> update(@RequestBody LocalisationDto localisationDto) throws NotFoundException {
        return ResponseEntity.ok(localisationService.update(localisationDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a localisation")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        localisationService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
