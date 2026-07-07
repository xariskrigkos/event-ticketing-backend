package com.xaris.eventticketing.exception;

public class TicketAlreadyExistsException extends RuntimeException {
    public TicketAlreadyExistsException(Long id) {
        super("Ticket with ID" + id +  " already exists");
    }
}