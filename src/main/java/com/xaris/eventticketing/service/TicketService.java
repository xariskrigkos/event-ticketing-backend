package com.xaris.eventticketing.service;

import com.xaris.eventticketing.exception.TicketAlreadyExistsException;
import com.xaris.eventticketing.exception.TicketNotFoundException;
import com.xaris.eventticketing.model.Reservation;
import com.xaris.eventticketing.model.Ticket;
import com.xaris.eventticketing.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Reservation reservation){
        Ticket ticket = new Ticket(reservation);
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }
}