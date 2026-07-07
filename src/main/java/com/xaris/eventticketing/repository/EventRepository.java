package com.xaris.eventticketing.repository;

import com.xaris.eventticketing.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,String> {
}