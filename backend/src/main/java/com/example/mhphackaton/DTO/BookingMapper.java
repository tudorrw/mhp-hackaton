package com.example.mhphackaton.DTO;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.Entities.Booking;

public class BookingMapper {
    public static BookingDTO mapToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setUserId(booking.getUser().getId());
        dto.setDeskId(booking.getDesk().getId());
        dto.setDate(booking.getDate());
        return dto;
    }
}
