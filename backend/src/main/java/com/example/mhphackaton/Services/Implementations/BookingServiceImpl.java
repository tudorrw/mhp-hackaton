package com.example.mhphackaton.Services.Implementations;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.DTO.DeskDTO;
import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.Repositories.BookingRepo;
import com.example.mhphackaton.Repositories.DeskRepo;
import com.example.mhphackaton.Repositories.UserRepo;
import com.example.mhphackaton.Services.Interfaces.BookingService;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DeskRepo deskRepo;

    @Override
    public LoginMessage bookDesk(BookingDTO bookingDTO) {
        if (isUserAvailableForBooking(bookingDTO.getUserId(), bookingDTO.getDate())) {
            // Check if the desk is available for booking
            if (isDeskAvailable(bookingDTO.getDeskId(), bookingDTO.getDate())) {
                // Create a new booking entity
                Booking booking = new Booking();
                booking.setId(bookingDTO.getUserId());
                booking.setUser(userRepo.getById(bookingDTO.getUserId()));
                booking.setDesk(deskRepo.getById(bookingDTO.getDeskId()));
                booking.setDate(bookingDTO.getDate());
                booking.setCreatedAt(bookingDTO.getCreatedAt());
                // Save the xbooking to the database
                bookingRepo.save(booking);
                return new LoginMessage("Desk booked successfully.",true);
            } else {
                return new LoginMessage("Desk is not available for booking at the specified date and time.", false);
            }
        } else {
            return new LoginMessage("User already has a booking at the specified date and time.", false);
        }
    }
    private boolean isUserAvailableForBooking(int userId, LocalDate date) {
        List<Booking> userBookings = bookingRepo.findByUserIdAndDate(userId, date);
        return userBookings.isEmpty();
    }
    private boolean isDeskAvailable(int deskId, LocalDate date) {
        List<Booking> deskBookings = bookingRepo.findByDeskIdAndDate(deskId, date);
        return deskBookings.isEmpty();
    }
}
