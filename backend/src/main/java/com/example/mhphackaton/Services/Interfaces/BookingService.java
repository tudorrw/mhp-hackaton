package com.example.mhphackaton.Services.Interfaces;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.UserAuthentication.LoginMessage;

public interface BookingService {
    LoginMessage bookDesk(BookingDTO bookingDTO);
}
