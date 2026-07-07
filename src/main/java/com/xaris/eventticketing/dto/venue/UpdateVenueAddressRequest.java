package com.xaris.eventticketing.dto.venue;

import jakarta.validation.constraints.NotBlank;

public class UpdateVenueAddressRequest {
    @NotBlank
    private String address;

    public UpdateVenueAddressRequest(){}

    public UpdateVenueAddressRequest(String address){
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
