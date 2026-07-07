package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.user.UpdateUserEmailRequest;
import com.xaris.eventticketing.dto.user.UpdateUserNameRequest;
import com.xaris.eventticketing.dto.user.UpdateUserPasswordHashRequest;
import com.xaris.eventticketing.model.User;
import com.xaris.eventticketing.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Users",
        description = "User management endpoints"
)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(
            summary = "Get all users",
            description = "Retrieves all users in the system."
    )
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(
            summary = "Get user by ID",
            description = "Retrieves a user using its unique identifier."
    )
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @Operation(
            summary = "Create a user",
            description = "Creates a new user in the system."
    )
    @PostMapping()
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @Operation(
            summary = "Delete a user",
            description = "Deletes a user from the system."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update a user's name",
            description = "Updates an existing user's name."
    )
    @PatchMapping("/{id}/name")
    public User updateUserName(@PathVariable String id, @Valid @RequestBody UpdateUserNameRequest request){
        return userService.updateUserName(id,request.getName());
    }

    @Operation(
            summary = "Update a user's email",
            description = "Updates an existing user's email."
    )
    @PatchMapping("/{id}/email")
    public User updateUserEmail(@PathVariable String id, @Valid @RequestBody UpdateUserEmailRequest request){
        return userService.updateUserEmail(id,request.getEmail());
    }

    @Operation(
            summary = "Update a user's password",
            description = "Updates an existing user's password."
    )
    @PatchMapping("/{id}/password")
    public User updateUserPasswordHash(@PathVariable String id, @Valid @RequestBody  UpdateUserPasswordHashRequest request){
        return userService.updateUserPasswordHash(id,request.getPasswordHash());
    }
}