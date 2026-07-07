package com.xaris.eventticketing.repository;

import com.xaris.eventticketing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}