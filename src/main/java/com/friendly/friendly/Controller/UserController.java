package com.friendly.friendly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.friendly.friendly.Dto.UserDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Service.UserService;

import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    @Schema(name = "Find all", description = "Find all users")
    public ResponseEntity<Page<UserDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(userService.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Schema(name = "Find by ID", description = "Find a user by ID")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    @Schema(name = "Save", description = "Save a new user")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping
    @Schema(name = "Update", description = "Update a user")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.update(userDto));
    }

    @DeleteMapping("{id}")
    @Schema(name = "Delete", description = "Delete a user")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    @Schema(name = "Register", description = "Register a new user")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.register(userDto));
    }

    @PostMapping("/login")
    @Schema(name = "Login", description = "Login a user")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.login(userDto));
    }
}
