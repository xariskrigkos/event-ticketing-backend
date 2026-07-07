package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.event.UpdateEventLocationRequest;
import com.xaris.eventticketing.dto.event.UpdateEventStartsAtRequest;
import com.xaris.eventticketing.dto.event.UpdateEventTitleRequest;
import com.xaris.eventticketing.dto.event.UpdateEventVenueRequest;
import com.xaris.eventticketing.model.Event;
import com.xaris.eventticketing.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping()
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id){
        return eventService.getEventById(id);
    }

    @PostMapping()
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        return ResponseEntity.status(201).body(eventService.createEvent(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id){
        eventService.removeEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/title")
    public Event updateEventTitle (@PathVariable String id, @Valid @RequestBody UpdateEventTitleRequest request){
        return eventService.updateEventTitle(id, request.getTitle());
    }

    @PatchMapping("/{id}/location")
    public Event updateEventLocation (@PathVariable String id, @Valid @RequestBody UpdateEventLocationRequest request){
        return eventService.updateLocation(id, request.getLocation());
    }

    @PatchMapping("/{id}/startsat")
    public Event updateEventStartsAt (@PathVariable String id,@Valid @RequestBody UpdateEventStartsAtRequest request){
        return eventService.updateStartsAt(id, request.getStartsAt());
    }

    @PatchMapping("/{id}/venue")
    public Event updateEventVenue(@PathVariable String id, @Valid @RequestBody UpdateEventVenueRequest request){
        return eventService.updateVenue(id, request.getVenueId());
    }
}