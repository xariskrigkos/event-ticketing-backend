package com.xaris.eventticketing.service;

import com.xaris.eventticketing.dto.venue.VenueDTO;
import com.xaris.eventticketing.exception.VenueAlreadyExistsException;
import com.xaris.eventticketing.exception.VenueNotFoundException;
import com.xaris.eventticketing.mapper.VenueMapper;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.repository.VenueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    public VenueService(VenueRepository venueRepository, VenueMapper venueMapper){
        this.venueRepository = venueRepository;
        this.venueMapper = venueMapper;
    }

    public VenueDTO createVenue(Venue venue){
        if(venueRepository.existsById(venue.getId())){
            throw new VenueAlreadyExistsException(venue.getId());
        }
        Venue saved = venueRepository.save(venue);
        return venueMapper.toDto(saved);
    }

    public Page<VenueDTO> getAllVenues(Pageable pageable) {
        return venueRepository.findAll(pageable)
                .map(venueMapper::toDto);
    }
    public VenueDTO getVenueById(String id){
        Venue venue = venueRepository.findById(id).orElseThrow(() -> new VenueNotFoundException(id));
        return  venueMapper.toDto(venue);
    }

    public Venue getVenueEntityById(String id){
        return venueRepository.findById(id).orElseThrow(() -> new VenueNotFoundException(id));
    }

    public void removeVenue(String id){
        Venue venue = getVenueEntityById(id);
        venueRepository.delete(venue);
    }

    public VenueDTO updateVenueName(String id, String name){
        Venue venue = getVenueEntityById(id);
        venue.setName(name);
        venueRepository.save(venue);
        return venueMapper.toDto(venue);
    }

    public VenueDTO updateAddress(String id, String address){
        Venue venue = getVenueEntityById(id);
        venue.setAddress(address);
        venueRepository.save(venue);
        return venueMapper.toDto(venue);
    }

    public VenueDTO updateCapacity(String id, int capacity){
        Venue venue = getVenueEntityById(id);
        venue.setCapacity(capacity);
        venueRepository.save(venue);
        return venueMapper.toDto(venue);    }
}