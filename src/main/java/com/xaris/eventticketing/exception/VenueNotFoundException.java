package com.xaris.eventticketing.exception;

public class VenueNotFoundException extends RuntimeException {
    public VenueNotFoundException(String id) {
        super("Venue with ID" + id + " not found");
    }
}