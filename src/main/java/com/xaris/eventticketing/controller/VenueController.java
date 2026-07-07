package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.venue.UpdateVenueAddressRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueCapacityRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueNameRequest;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Venues",
        description = "Venue management endpoints"
)
@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService = venueService;
    }

    @Operation(
            summary = "Get all venues",
            description = "Retrieves all venues in the system."
    )
    @GetMapping()
    public List<Venue> getVenues(){
        return venueService.getAllVenues();
    }

    @Operation(
            summary = "Get venue by ID",
            description = "Retrieves a venue using its unique identifier."
    )
    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable String id){
        return venueService.getVenueById(id);
    }

    @Operation(
            summary = "Create a venue",
            description = "Creates a new venue in the system."
    )
    @PostMapping()
    public ResponseEntity<Venue> addVenue(@Valid @RequestBody Venue venue){
        return ResponseEntity.status(201).body(venueService.createVenue(venue));
    }

    @Operation(
            summary = "Delete a venue",
            description = "Deletes a venue from the system."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVenue(@PathVariable String id){
        venueService.removeVenue(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update a venue's name",
            description = "Updates an existing venue's name."
    )
    @PatchMapping ("/{id}/name")
    public Venue updateVenueName (@PathVariable String id,@Valid @RequestBody UpdateVenueNameRequest request){
        return venueService.updateVenueName(id, request.getName());
    }

    @Operation(
            summary = "Update a venue's address",
            description = "Updates an existing venue's address."
    )
    @PatchMapping("{id}/address")
    public Venue updateVenueAddress (@PathVariable String id,@Valid @RequestBody UpdateVenueAddressRequest reqeust ){
        return venueService.updateAddress(id, reqeust.getAddress());
    }

    @Operation(
            summary = "Update a venue's capacity",
            description = "Updates an existing venue's capacity."
    )
    @PatchMapping("/{id}/capacity")
    public Venue updateVenueCapacity (@PathVariable String id,@Valid @RequestBody UpdateVenueCapacityRequest request ){
        return venueService.updateCapacity(id,request.getCapacity());
    }

}