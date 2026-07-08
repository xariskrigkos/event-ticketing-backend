package com.xaris.eventticketing.mapper;

import com.xaris.eventticketing.dto.event.EventDTO;
import com.xaris.eventticketing.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDto(Event event) {

        EventDTO dto = new EventDTO();

        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setLocation(event.getLocation());
        dto.setVenueId(event.getVenue().getId());
        dto.setStartsAt(event.getStartsAt());
        dto.setTicketsRemaining(event.getTicketsRemaining());

        return dto;
    }
}