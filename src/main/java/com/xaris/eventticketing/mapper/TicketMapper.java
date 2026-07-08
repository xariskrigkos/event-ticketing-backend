package com.xaris.eventticketing.mapper;

import com.xaris.eventticketing.dto.ticket.TicketDTO;
import com.xaris.eventticketing.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDTO toDto(Ticket ticket) {

        TicketDTO dto = new TicketDTO();

        dto.setId(ticket.getId());
        dto.setReservationId(ticket.getReservation().getId());
        dto.setEventId(ticket.getReservation().getEvent().getId());

        return dto;
    }
}
