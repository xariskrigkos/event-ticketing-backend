package com.xaris.eventticketing.repository;

import com.xaris.eventticketing.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue,String> {
}