package com.xaris.eventticketing.exception;

public class ReservationAlreadyFulfilledException extends RuntimeException {
    public ReservationAlreadyFulfilledException(Long id) {
        super("Reservation with ID" + id + " has already been fulfilled");
    }
}