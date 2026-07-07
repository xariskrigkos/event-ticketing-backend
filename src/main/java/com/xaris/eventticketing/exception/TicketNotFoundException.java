package com.xaris.eventticketing.exception;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super("Ticket with ID" + id + " not found");
    }
}