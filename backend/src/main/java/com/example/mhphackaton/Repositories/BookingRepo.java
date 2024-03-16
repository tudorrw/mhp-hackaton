package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
