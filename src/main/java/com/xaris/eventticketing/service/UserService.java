package com.xaris.eventticketing.service;

import com.xaris.eventticketing.dto.user.UserDTO;
import com.xaris.eventticketing.exception.UserAlreadyExistsException;
import com.xaris.eventticketing.exception.UserNotFoundException;
import com.xaris.eventticketing.mapper.UserMapper;
import com.xaris.eventticketing.model.User;
import com.xaris.eventticketing.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(User user){
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException(user.getId());
        }
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }
    public UserDTO getUserById(String id){
        User user =  userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return  userMapper.toDto(user);
    }

    public User getUserEntityById(String id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void removeUser(String id){
        User user = getUserEntityById(id);
        userRepository.delete(user);
    }

    public UserDTO updateUserEmail(String id, String email){
        User user = getUserEntityById(id);
        user.setEmail(email);
        userRepository.save(user);
        return  userMapper.toDto(user);
    }

    public UserDTO updateUserName(String id, String name){
        User user = getUserEntityById(id);
        user.setName(name);
        userRepository.save(user);
        return  userMapper.toDto(user);
    }

    public UserDTO updateUserPasswordHash(String id, String passwordHash){
        User user = getUserEntityById(id);
        user.setPasswordHash(passwordHash);
        userRepository.save(user);
        return  userMapper.toDto(user);
    }
}