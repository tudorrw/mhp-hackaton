package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.Entities.Booking;
import com.example.mhphackaton.Services.Interfaces.BookingService;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/{date}")
    public ResponseEntity<List<BookingDTO>> getReservationsByDate(@PathVariable String date) {
        LocalDate bookingDate = LocalDate.parse(date);
        System.out.println(bookingDate);
        List<BookingDTO> bookings = bookingService.getBookingsByDate(bookingDate);
        return ResponseEntity.ok(bookings);
    }
    @PostMapping
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) {
        LoginMessage loginMessage = bookingService.bookDesk(bookingDTO);
        return ResponseEntity.ok(loginMessage);
    }


}
