package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.ConferenceRoomBooking;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ConferenceRoomBookingRepo extends JpaRepository <ConferenceRoomBooking, Integer> {
    LoginMessage bookConferenceRoom(int userId, LocalDate date);
}
