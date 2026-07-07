package com.xaris.eventticketing.dto.venue;

import jakarta.validation.constraints.NotBlank;

public class UpdateVenueNameRequest {
    @NotBlank
    private String name;

    public UpdateVenueNameRequest(){}

    public UpdateVenueNameRequest(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
