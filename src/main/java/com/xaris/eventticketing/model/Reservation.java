package com.xaris.eventticketing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User owner;
    @ManyToOne
    private Event event;
    @Positive
    private int ticketQuantity;
    @NotNull
    private ReservationStatus reservationStatus;
    @NotNull
    private LocalDateTime createdAt;

    public Reservation(){}

    public Reservation(User owner, Event event, int ticketQuantity, ReservationStatus reservationStatus
    ,LocalDateTime createdAt){
        this.owner = owner;
        this.event = event;
        this.ticketQuantity = ticketQuantity;
        this.reservationStatus = reservationStatus;
        this.createdAt = createdAt;
    }

    public User getOwner() {
        return owner;
    }


    public Event getEvent() {
        return event;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }
}