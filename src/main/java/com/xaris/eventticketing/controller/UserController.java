package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.user.UpdateUserEmailRequest;
import com.xaris.eventticketing.dto.user.UpdateUserNameRequest;
import com.xaris.eventticketing.dto.user.UpdateUserPasswordHashRequest;
import com.xaris.eventticketing.model.User;
import com.xaris.eventticketing.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public User updateUserName(@PathVariable String id, @Valid @RequestBody UpdateUserNameRequest request){
        return userService.updateUserName(id,request.getName());
    }

    @PatchMapping("/{id}/email")
    public User updateUserEmail(@PathVariable String id, @Valid @RequestBody UpdateUserEmailRequest request){
        return userService.updateUserEmail(id,request.getEmail());
    }

    @PatchMapping("/{id}/password")
    public User updateUserPasswordHash(@PathVariable String id, @Valid @RequestBody  UpdateUserPasswordHashRequest request){
        return userService.updateUserPasswordHash(id,request.getPasswordHash());
    }
}