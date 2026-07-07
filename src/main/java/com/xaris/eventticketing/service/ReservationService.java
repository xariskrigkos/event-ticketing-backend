package com.xaris.eventticketing.service;

import com.xaris.eventticketing.exception.*;
import com.xaris.eventticketing.model.*;
import com.xaris.eventticketing.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final ReservationRepository reservationRepository;
    private final TicketService ticketService;

    public ReservationService(UserRepository userRepository, EventRepository eventRepository,
                              ReservationRepository reservationRepository, TicketService ticketService){
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.reservationRepository = reservationRepository;
        this.ticketService = ticketService;
    }

    public Reservation createReservation(String userId, String eventId, int ticketQuantity){
        User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        if(ticketQuantity > event.getTicketsRemaining()){
            throw new InsufficientTicketsException();
        }
        event.setTicketsRemaining(event.getTicketsRemaining() - ticketQuantity);
        eventRepository.save(event);
        Reservation reservation = new Reservation(owner,event,
                ticketQuantity, ReservationStatus.PENDING, LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long id){
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }

    public Reservation fulfillReservation(Long id){
        Reservation reservation = getReservationById(id);
        if(reservation.getReservationStatus() == ReservationStatus.FULFILLED){
            throw new ReservationAlreadyFulfilledException(id);
        }
        reservation.setReservationStatus(ReservationStatus.FULFILLED);
        Reservation updatedReservation = reservationRepository.save(reservation);
        ticketService.issueTicket(reservation);
        return updatedReservation;
    }
}