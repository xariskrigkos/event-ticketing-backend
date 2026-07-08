package com.xaris.eventticketing.mapper;

import com.xaris.eventticketing.dto.reservation.ReservationDTO;
import com.xaris.eventticketing.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationDTO toDto(Reservation reservation) {

        ReservationDTO dto = new ReservationDTO();

        dto.setId(reservation.getId());

        dto.setUserId(reservation.getOwner().getId());
        dto.setUserName(reservation.getOwner().getName());

        dto.setEventId(reservation.getEvent().getId());
        dto.setEventTitle(reservation.getEvent().getTitle());

        dto.setTicketQuantity(reservation.getTicketQuantity());

        dto.setReservationStatus(reservation.getReservationStatus());

        dto.setCreatedAt(reservation.getCreatedAt());

        return dto;
    }
}