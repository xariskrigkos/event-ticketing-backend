package com.xaris.eventticketing.dto.venue;

import jakarta.validation.constraints.Positive;

public class UpdateVenueCapacityRequest {

    @Positive
    private int capacity;

    public  UpdateVenueCapacityRequest(){}

    public UpdateVenueCapacityRequest(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
