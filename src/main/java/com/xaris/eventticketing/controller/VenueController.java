package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.venue.UpdateVenueAddressRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueCapacityRequest;
import com.xaris.eventticketing.dto.venue.UpdateVenueNameRequest;
import com.xaris.eventticketing.dto.venue.VenueDTO;
import com.xaris.eventticketing.model.Venue;
import com.xaris.eventticketing.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @GetMapping
    public Page<VenueDTO> getAllVenues(Pageable pageable) {
        return venueService.getAllVenues(pageable);
    }

    @Operation(
            summary = "Get venue by ID",
            description = "Retrieves a venue using its unique identifier."
    )
    @GetMapping("/{id}")
    public VenueDTO getVenueById(@PathVariable String id){
        return venueService.getVenueById(id);
    }

    @Operation(
            summary = "Create a venue",
            description = "Creates a new venue in the system."
    )
    @PostMapping()
    public ResponseEntity<VenueDTO> addVenue(@Valid @RequestBody Venue venue){
        VenueDTO created = venueService.createVenue(venue);
        return ResponseEntity.status(201).body(created);
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
    public VenueDTO updateVenueName (@PathVariable String id,@Valid @RequestBody UpdateVenueNameRequest request){
        return venueService.updateVenueName(id, request.getName());
    }

    @Operation(
            summary = "Update a venue's address",
            description = "Updates an existing venue's address."
    )
    @PatchMapping("{id}/address")
    public VenueDTO updateVenueAddress (@PathVariable String id,@Valid @RequestBody UpdateVenueAddressRequest reqeust ){
        return venueService.updateAddress(id, reqeust.getAddress());
    }

    @Operation(
            summary = "Update a venue's capacity",
            description = "Updates an existing venue's capacity."
    )
    @PatchMapping("/{id}/capacity")
    public VenueDTO updateVenueCapacity (@PathVariable String id,@Valid @RequestBody UpdateVenueCapacityRequest request ){
        return venueService.updateCapacity(id,request.getCapacity());
    }

}