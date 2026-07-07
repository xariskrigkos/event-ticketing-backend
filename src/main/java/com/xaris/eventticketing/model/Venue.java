package com.xaris.eventticketing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Venue {
    @NotBlank
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Positive
    private int capacity;

    public Venue(){
    }

    public Venue(String name, String address, int capacity){
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " Name: " + this.name + " Address: " + this.address + " Capacity" +
                this.capacity;
    }
}