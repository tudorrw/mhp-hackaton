package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
     LoginMessage bookDesk(int userId, LocalDate date);
}
