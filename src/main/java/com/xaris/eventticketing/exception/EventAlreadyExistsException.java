package com.xaris.eventticketing.exception;

public class EventAlreadyExistsException extends RuntimeException {
    public EventAlreadyExistsException(String id) {
        super("Event with ID" + id +  " already exists");
    }
}