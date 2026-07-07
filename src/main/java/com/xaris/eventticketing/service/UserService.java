package com.xaris.eventticketing.service;

import com.xaris.eventticketing.exception.UserAlreadyExistsException;
import com.xaris.eventticketing.exception.UserNotFoundException;
import com.xaris.eventticketing.model.User;
import com.xaris.eventticketing.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException(user.getId());
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void removeUser(String id){
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public User updateUserEmail(String id, String email){
        User user = getUserById(id);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User updateUserName(String id, String name){
        User user = getUserById(id);
        user.setName(name);
        return userRepository.save(user);
    }

    public User updateUserPasswordHash(String id, String passwordHash){
        User user = getUserById(id);
        user.setPasswordHash(passwordHash);
        return userRepository.save(user);
    }
}