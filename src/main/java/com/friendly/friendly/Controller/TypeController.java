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

import com.friendly.friendly.Dto.TypeDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.TypeService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/type")
public class TypeController {
    
    @Autowired
    private TypeService typeService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all types")
    public ResponseEntity<Page<TypeDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(typeService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a type by ID")
    public ResponseEntity<TypeDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(typeService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new type")
    public ResponseEntity<TypeDto> save(@RequestBody TypeDto typeDto) {
        return ResponseEntity.ok(typeService.save(typeDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a type")
    public ResponseEntity<TypeDto> update(@RequestBody TypeDto typeDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(typeService.update(typeDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a type")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
