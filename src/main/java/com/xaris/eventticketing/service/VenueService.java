package com.xaris.eventticketing.service;

import com.xaris.eventticketing.exception.VenueAlreadyExistsException;
import com.xaris.eventticketing.exception.VenueNotFoundException;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    public Venue createVenue(Venue venue){
        if(venueRepository.existsById(venue.getId())){
            throw new VenueAlreadyExistsException(venue.getId());
        }
        return venueRepository.save(venue);
    }

    public List<Venue> getAllVenues(){
        return venueRepository.findAll();
    }
    public Venue getVenueById(String id){
        return venueRepository.findById(id).orElseThrow(() -> new VenueNotFoundException(id));
    }

    public void removeVenue(String id){
        Venue venue = getVenueById(id);
        venueRepository.delete(venue);
    }

    public Venue updateVenueName(String id, String name){
        Venue venue = getVenueById(id);
        venue.setName(name);
        return venueRepository.save(venue);
    }

    public Venue updateAddress(String id, String address){
        Venue venue = getVenueById(id);
        venue.setAddress(address);
        return venueRepository.save(venue);
    }

    public Venue updateCapacity(String id, int capacity){
        Venue venue = getVenueById(id);
        venue.setCapacity(capacity);
        return venueRepository.save(venue);
    }
}