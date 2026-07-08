package com.xaris.eventticketing.controller;

import com.xaris.eventticketing.dto.ticket.TicketDTO;
import com.xaris.eventticketing.model.Ticket;
import com.xaris.eventticketing.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Tickets",
        description = "Ticket management endpoints"
)
@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Operation(
            summary = "Get ticket by ID",
            description = "Retrieves a ticket using its unique identifier."
    )
    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @Operation(
            summary = "Get all tickets",
            description = "Retrieves all tickets."
    )
    @GetMapping
    public Page<TicketDTO> getAllTickets(Pageable pageable) {
        return ticketService.getAllTickets(pageable);
    }

    @Operation(
            summary = "Get ticket by reservation ID",
            description = "Retrieves tickets via the ID of their reservation."
    )
    @GetMapping("/reservation/{reservationId}")
    public List<TicketDTO> getTicketsByReservationId(@PathVariable Long reservationId) {
        return ticketService.getTicketsByReservationId(reservationId);
    }}
