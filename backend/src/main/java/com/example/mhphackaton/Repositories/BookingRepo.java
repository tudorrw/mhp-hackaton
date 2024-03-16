package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserIdAndDate(int id, LocalDate date);

    List<Booking> findByDeskIdAndDate(int deskId, LocalDate date);
}

