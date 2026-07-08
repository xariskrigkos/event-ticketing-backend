package com.xaris.eventticketing.service;

import com.xaris.eventticketing.dto.reservation.ReservationDTO;
import com.xaris.eventticketing.exception.*;
import com.xaris.eventticketing.mapper.ReservationMapper;
import com.xaris.eventticketing.model.*;
import com.xaris.eventticketing.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final ReservationRepository reservationRepository;
    private final TicketService ticketService;
    private final ReservationMapper reservationMapper;

    public ReservationService(UserRepository userRepository, EventRepository eventRepository,
                              ReservationRepository reservationRepository, TicketService ticketService,
                              ReservationMapper reservationMapper){
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.reservationRepository = reservationRepository;
        this.ticketService = ticketService;
        this.reservationMapper = reservationMapper;
    }
    @Transactional
    public ReservationDTO createReservation(String userId, String eventId, int ticketQuantity){
        User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        if(ticketQuantity > event.getTicketsRemaining()){
            throw new InsufficientTicketsException();
        }
        event.setTicketsRemaining(event.getTicketsRemaining() - ticketQuantity);
        eventRepository.save(event);
        Reservation reservation = new Reservation(owner,event,
                ticketQuantity, ReservationStatus.PENDING, LocalDateTime.now());
        Reservation saved = reservationRepository.save(reservation);
        return  reservationMapper.toDto(saved);
    }

    public Reservation getReservationEntityById(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public ReservationDTO getReservationById(Long id){
        Reservation reservation= reservationRepository.findById(id).orElseThrow(()
                -> new ReservationNotFoundException(id));
        return reservationMapper.toDto(reservation);
    }

    public Page<ReservationDTO> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable)
                .map(reservationMapper::toDto);
    }

    public void deleteReservation(Long id){
        Reservation reservation = getReservationEntityById(id);
        reservationRepository.delete(reservation);
    }
    @Transactional
    public ReservationDTO fulfillReservation(Long id){
        Reservation reservation = getReservationEntityById(id);
        if(reservation.getReservationStatus() == ReservationStatus.FULFILLED){
            throw new ReservationAlreadyFulfilledException(id);
        }
        reservation.setReservationStatus(ReservationStatus.FULFILLED);
        Reservation updatedReservation = reservationRepository.save(reservation);
        ticketService.issueTicketForReservation(reservation);
        return reservationMapper.toDto(reservation);
    }
}