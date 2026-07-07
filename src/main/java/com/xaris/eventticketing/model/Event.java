package com.xaris.eventticketing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Entity
public class Event {
    @NotBlank
    @Id
    private String  id;
    @NotBlank
    private String title;
    @NotBlank
    private String location;
    @ManyToOne
    private Venue venue;
    @NotNull
    private LocalDateTime startsAt;
    @PositiveOrZero
    private int ticketsRemaining;
    @Version
    private Long version;


    public Event(){}

    public Event(String title, String location, Venue venue, LocalDateTime startsAt, int ticketsRemaining){
        this.title = title;
        this.location = location;
        this.venue = venue;
        this.startsAt = startsAt;
        this.ticketsRemaining = ticketsRemaining;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public int getTicketsRemaining() {
        return ticketsRemaining;
    }

    public void setTicketsRemaining(int ticketsRemaining) {
        this.ticketsRemaining = ticketsRemaining;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " Title:" + this.title + " Location: " + this.location
                + " Venue: " + this.venue.getName() + " Starts at: " + this.startsAt
                + " Remaining tickets: " + this.ticketsRemaining;
    }

    public Long getVersion() {
        return version;
    }
}