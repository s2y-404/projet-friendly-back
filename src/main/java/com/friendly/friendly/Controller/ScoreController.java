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

import com.friendly.friendly.Dto.ScoreDto;
import com.friendly.friendly.Service.ScoreService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    @Schema(name = "Find All", description = "Retrieve all scores with pagination.")
    public ResponseEntity<Page<ScoreDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<ScoreDto> scores = scoreService.findAll(page, size);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Retrieve a specific score by its ID.")
    public ResponseEntity<ScoreDto> findById(@PathVariable Long id) throws NotFoundException {
        ScoreDto scoreDto = scoreService.findById(id);
        return ResponseEntity.ok(scoreDto);
    }

    @PostMapping
    @Schema(name = "Save", description = "Create a new score.")
    public ResponseEntity<ScoreDto> save(@Valid @RequestBody ScoreDto scoreDto) {
        ScoreDto savedScore = scoreService.save(scoreDto);
        return ResponseEntity.ok(savedScore);
    }

    @PutMapping
    @Schema(name = "Update", description = "Update an existing score.")
    public ResponseEntity<ScoreDto> update(@Valid @RequestBody ScoreDto scoreDto) throws NotFoundException {
        ScoreDto updatedScore = scoreService.update(scoreDto);
        return ResponseEntity.ok(updatedScore);
    }

    @DeleteMapping("/{id}")
    @Schema(name = "Delete", description = "Delete a score by its ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scoreService.delete(id);
        return ResponseEntity.noContent().build();
    }  
}
