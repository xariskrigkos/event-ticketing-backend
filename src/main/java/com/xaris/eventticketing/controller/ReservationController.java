package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.reservation.CreateReservationRequest;
import com.xaris.eventticketing.model.Reservation;
import com.xaris.eventticketing.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @GetMapping()
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody CreateReservationRequest
                                                                     request){
        return  ResponseEntity.status(201).body(reservationService.createReservation(
                request.getUserId(), request.getEventId(), request.getCapacity()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return  ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/fulfill")
    public Reservation updateReservationStatus(@PathVariable Long id){
        return reservationService.fulfillReservation(id);
    }
}
