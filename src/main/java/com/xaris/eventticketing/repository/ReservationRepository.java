package com.xaris.eventticketing.repository;

import com.xaris.eventticketing.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}