package com.xaris.eventticketing.exception;

public class VenueAlreadyExistsException extends RuntimeException {
    public VenueAlreadyExistsException(String id) {
        super("Venue with ID" + id +  " already exists");
    }
}