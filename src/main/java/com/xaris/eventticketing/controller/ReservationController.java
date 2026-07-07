package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.reservation.CreateReservationRequest;
import com.xaris.eventticketing.model.Reservation;
import com.xaris.eventticketing.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Reservations",
        description = "Reservation management endpoints"
)
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @Operation(
            summary = "Get reservation by ID",
            description = "Retrieves a reservation using its unique identifier."
    )
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @Operation(
            summary = "Get all reservations",
            description = "Retrieves all reservations in the system."
    )
    @GetMapping()
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @Operation(
            summary = "Create a reservation",
            description = "Create a pending reservation for a user if enough tickets are available."
    )
    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody CreateReservationRequest
                                                                     request){
        return  ResponseEntity.status(201).body(reservationService.createReservation(
                request.getUserId(), request.getEventId(), request.getCapacity()));
    }

    @Operation(
            summary = "Delete a reservation",
            description = "Deletes a reservation from the system."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return  ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Fulfill a reservation",
            description = "Marks a reservation as fulfilled and generates the corresponding ticket."
    )
    @PatchMapping("/{id}/fulfill")
    public Reservation updateReservationStatus(@PathVariable Long id){
        return reservationService.fulfillReservation(id);
    }
}
