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

import com.friendly.friendly.Dto.PartyDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.PartyService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/party")
public class PartyController {
    
    @Autowired
    private PartyService partyService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all partys")
    public ResponseEntity<Page<PartyDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(partyService.findAll(page, size));
    }

    @GetMapping("/year/{year}")
    @Schema(name = "Find by year", description = "Find all partys for a specific year")
    public ResponseEntity<Page<PartyDto>> findAllByYear(@PathVariable int year,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(partyService.findAllByYear(year, page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a party by ID")
    public ResponseEntity<PartyDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(partyService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new party")
    public ResponseEntity<PartyDto> save(@RequestBody PartyDto partyDto) {
        return ResponseEntity.ok(partyService.save(partyDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a party")
    public ResponseEntity<PartyDto> update(@RequestBody PartyDto partyDto) {
        return ResponseEntity.ok(partyService.update(partyDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a party")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partyService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}
