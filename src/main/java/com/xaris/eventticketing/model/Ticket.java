package com.xaris.eventticketing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    private Reservation reservation;

    public Ticket(){}

    public Ticket(Reservation reservation){
        this.reservation = reservation;

    }

    public Long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }
}