package com.xaris.eventticketing.dto.event;

import jakarta.validation.constraints.NotBlank;

public class UpdateEventVenueRequest {
    @NotBlank
    private String venueId;

    public UpdateEventVenueRequest(String venueId){
        this.venueId = venueId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }
}
