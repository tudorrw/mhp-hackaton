package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface BookingRepo extends JpaRepository<Booking, Integer> {
}

