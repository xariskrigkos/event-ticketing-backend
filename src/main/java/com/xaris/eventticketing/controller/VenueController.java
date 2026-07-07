package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.venue.UpdateVenueAddressRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueCapacityRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueNameRequest;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService = venueService;
    }

    @GetMapping()
    public List<Venue> getVenues(){
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable String id){
        return venueService.getVenueById(id);
    }

    @PostMapping()
    public ResponseEntity<Venue> addVenue(@Valid @RequestBody Venue venue){
        return ResponseEntity.status(201).body(venueService.createVenue(venue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVenue(@PathVariable String id){
        venueService.removeVenue(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping ("/{id}/name")
    public Venue updateVenueName (@PathVariable String id,@Valid @RequestBody UpdateVenueNameRequest request){
        return venueService.updateVenueName(id, request.getName());
    }

    @PatchMapping("{id}/address")
    public Venue updateVenueAddress (@PathVariable String id,@Valid @RequestBody UpdateVenueAddressRequest reqeust ){
        return venueService.updateAddress(id, reqeust.getAddress());
    }

    @PatchMapping("/{id}/capacity")
    public Venue updateVenueCapacity (@PathVariable String id,@Valid @RequestBody UpdateVenueCapacityRequest request ){
        return venueService.updateCapacity(id,request.getCapacity());
    }

}