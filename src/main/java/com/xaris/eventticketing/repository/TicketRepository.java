package com.xaris.eventticketing.repository;

import com.xaris.eventticketing.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByReservationId(Long reservationId);
}