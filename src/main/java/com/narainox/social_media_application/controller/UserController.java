package com.narainox.social_media_application.controller;

import com.narainox.social_media_application.dto.CreateUserDto;
import com.narainox.social_media_application.dto.UpdateUserDto;
import com.narainox.social_media_application.dto.UserResponseDto;
import com.narainox.social_media_application.handler.ResponseHandler;
import com.narainox.social_media_application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseHandler.generateResponse("Users retrieved successfully", HttpStatus.OK, userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return ResponseHandler.generateResponse("User retrieved successfully", HttpStatus.OK, userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        UserResponseDto user = userService.createUser(createUserDto);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseHandler.generateResponse("User created successfully", HttpStatus.CREATED, user);
    }

    @PatchMapping
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        UserResponseDto user = userService.updateUser(updateUserDto);
        return ResponseHandler.generateResponse("User updated successfully", HttpStatus.OK, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseHandler.generateResponse("User deleted successfully", HttpStatus.OK, null);
    }

}
