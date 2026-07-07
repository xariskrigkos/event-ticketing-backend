package com.xaris.eventticketing.exception;

public class InsufficientTicketsException extends RuntimeException {
    public InsufficientTicketsException() {
        super("Insufficient tickets to fulfill reservation");
    }
}