package com.xaris.eventticketing.service;

import com.xaris.eventticketing.dto.ticket.TicketDTO;
import com.xaris.eventticketing.exception.TicketNotFoundException;
import com.xaris.eventticketing.mapper.TicketMapper;
import com.xaris.eventticketing.model.Reservation;
import com.xaris.eventticketing.model.Ticket;
import com.xaris.eventticketing.repository.TicketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository,TicketMapper ticketMapper){
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<Ticket> issueTicketForReservation(Reservation reservation){
        int ticketQuantity = reservation.getTicketQuantity();
        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < ticketQuantity; i++){
            tickets.add(new Ticket(reservation));
        }

        return ticketRepository.saveAll(tickets);
    }

    public Page<TicketDTO> getAllTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable)
                .map(ticketMapper::toDto);
    }

    public TicketDTO getTicketById(Long id){
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        return ticketMapper.toDto(ticket);
    }

    public List<TicketDTO> getTicketsByReservationId(Long reservationId) {
        return ticketRepository.findByReservationId(reservationId).stream().map(ticketMapper::toDto).toList();
    }
}