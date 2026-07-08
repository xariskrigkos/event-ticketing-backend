package com.xaris.eventticketing.service;

import com.xaris.eventticketing.dto.event.EventDTO;
import com.xaris.eventticketing.exception.EventAlreadyExistsException;
import com.xaris.eventticketing.exception.EventNotFoundException;
import com.xaris.eventticketing.exception.VenueNotFoundException;
import com.xaris.eventticketing.mapper.EventMapper;
import com.xaris.eventticketing.model.Event;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.repository.EventRepository;
import com.xaris.eventticketing.repository.VenueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, VenueRepository venueRepository,
                        EventMapper eventMapper) {

        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.eventMapper = eventMapper;
    }

    public EventDTO createEvent(Event event){
        if(eventRepository.existsById(event.getId())){
            throw new EventAlreadyExistsException(event.getId());
        }
        Event saved = eventRepository.save(event);
        return  eventMapper.toDto(saved);
    }

    public Page<EventDTO> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable)
                .map(eventMapper::toDto);
    }

    public EventDTO getEventById(String id) {
        Event event = getEventEntityById(id);
        return eventMapper.toDto(event);
    }

    public Event getEventEntityById(String id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public void removeEvent(String id){
        Event event = getEventEntityById(id);
        eventRepository.delete(event);
    }

    public EventDTO updateEventTitle(String id, String title){
        Event event = getEventEntityById(id);
        event.setTitle(title);
        eventRepository.save(event);
        return  eventMapper.toDto(event);
    }

    public EventDTO updateLocation(String id, String location){
        Event event = getEventEntityById(id);
        event.setLocation(location);
        eventRepository.save(event);
        return  eventMapper.toDto(event);
    }

    public EventDTO updateVenue(String eventId, String venueId){
        Event event = getEventEntityById(eventId);
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new VenueNotFoundException(venueId));
        event.setVenue(venue);
        eventRepository.save(event);
        return  eventMapper.toDto(event);
    }

    public EventDTO updateStartsAt(String id, LocalDateTime startsAt){
        Event event = getEventEntityById(id);
        event.setStartsAt(startsAt);
        eventRepository.save(event);
        return  eventMapper.toDto(event);
    }

}