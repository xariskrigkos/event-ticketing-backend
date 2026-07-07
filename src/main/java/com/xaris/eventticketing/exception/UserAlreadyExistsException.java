package com.xaris.eventticketing.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String id) {
        super("User with ID" + id +  " already exists");
    }
}