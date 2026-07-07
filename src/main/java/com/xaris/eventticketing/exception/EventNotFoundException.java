package com.xaris.eventticketing.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String id) {
        super("Event with ID" + id + " not found");
    }
}