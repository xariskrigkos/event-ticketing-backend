package com.xaris.eventticketing.mapper;

import com.xaris.eventticketing.dto.venue.VenueDTO;
import com.xaris.eventticketing.model.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {

    public VenueDTO toDto(Venue venue) {

        VenueDTO dto = new VenueDTO();

        dto.setId(venue.getId());
        dto.setName(venue.getName());
        dto.setAddress(venue.getAddress());

        return dto;
    }
}