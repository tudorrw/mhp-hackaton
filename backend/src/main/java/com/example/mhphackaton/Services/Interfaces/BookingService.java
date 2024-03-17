package com.example.mhphackaton.Services.Interfaces;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.UserAuthentication.LoginMessage;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    LoginMessage bookDesk(BookingDTO bookingDTO);

    List<BookingDTO> getBookingsByDate(LocalDate date);
}
