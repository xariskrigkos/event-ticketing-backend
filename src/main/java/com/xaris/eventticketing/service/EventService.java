package com.xaris.eventticketing.service;

import com.xaris.eventticketing.exception.EventAlreadyExistsException;
import com.xaris.eventticketing.exception.EventNotFoundException;
import com.xaris.eventticketing.exception.VenueNotFoundException;
import com.xaris.eventticketing.model.Event;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.repository.EventRepository;
import com.xaris.eventticketing.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public EventService(EventRepository eventRepository, VenueRepository venueRepository){
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    public Event createEvent(Event event){
        if(eventRepository.existsById(event.getId())){
            throw new EventAlreadyExistsException(event.getId());
        }
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(String id){
       return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public void removeEvent(String id){
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public Event updateEventTitle(String id, String title){
        Event event = getEventById(id);
        event.setTitle(title);
        return eventRepository.save(event);
    }

    public Event updateLocation(String id, String location){
        Event event = getEventById(id);
        event.setLocation(location);
        return eventRepository.save(event);
    }

    public Event updateVenue(String eventId, String venueId){
        Event event = getEventById(eventId);
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new VenueNotFoundException(venueId));
        event.setVenue(venue);
        return eventRepository.save(event);
    }

    public Event updateStartsAt(String id, LocalDateTime startsAt){
        Event event = getEventById(id);
        event.setStartsAt(startsAt);
        return eventRepository.save(event);
    }

}