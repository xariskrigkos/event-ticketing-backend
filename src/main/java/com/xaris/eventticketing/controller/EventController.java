package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.event.*;
import com.xaris.eventticketing.model.Event;
import com.xaris.eventticketing.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Events",
        description = "Event management endpoints"
)
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @Operation(
            summary = "Get all events",
            description = "Retrieves all events in the system."
    )
    @GetMapping()
    public Page<EventDTO> getAllEvents(Pageable pageable) {
        return eventService.getAllEvents(pageable);
    }

    @Operation(
            summary = "Get event by ID",
            description = "Retrieves an event using its unique identifier."
    )
    @GetMapping("/{id}")
    public EventDTO getEventById(@PathVariable String id){
        return  eventService.getEventById(id);
    }

    @Operation(
            summary = "Create an event",
            description = "Creates a new event associated with a venue."
    )
    @PostMapping()
    public ResponseEntity<EventDTO> addEvent(@RequestBody Event event){
        EventDTO created = eventService.createEvent(event);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(
            summary = "Delete an event",
            description = "Deletes an event from the system."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id){
        eventService.removeEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update event title",
            description = "Assigns or updates the title of the event."
    )
    @PatchMapping("/{id}/title")
    public EventDTO updateEventTitle (@PathVariable String id, @Valid @RequestBody UpdateEventTitleRequest request){
        return eventService.updateEventTitle(id, request.getTitle());
    }

    @Operation(
            summary = "Update event location",
            description = "Assigns or updates the location associated with an event."
    )
    @PatchMapping("/{id}/location")
    public EventDTO updateEventLocation (@PathVariable String id, @Valid @RequestBody UpdateEventLocationRequest request){
        return eventService.updateLocation(id, request.getLocation());
    }

    @Operation(
            summary = "Update event starting time",
            description = "Assigns or updates the starting time associated with an event."
    )
    @PatchMapping("/{id}/startsat")
    public EventDTO updateEventStartsAt (@PathVariable String id,@Valid @RequestBody UpdateEventStartsAtRequest request){
        return eventService.updateStartsAt(id, request.getStartsAt());
    }

    @Operation(
            summary = "Update event venue",
            description = "Assigns or updates the venue associated with an event."
    )
    @PatchMapping("/{id}/venue")
    public EventDTO updateEventVenue(@PathVariable String id, @Valid @RequestBody UpdateEventVenueRequest request){
        return eventService.updateVenue(id, request.getVenueId());
    }
}