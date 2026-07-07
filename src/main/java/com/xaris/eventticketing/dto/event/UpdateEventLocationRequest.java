package com.xaris.eventticketing.dto.event;

import jakarta.validation.constraints.NotBlank;

public class UpdateEventLocationRequest {
    @NotBlank
    private String location;

    public UpdateEventLocationRequest(String location){
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
