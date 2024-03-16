package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.DTO.BookingDTO;
import com.example.mhphackaton.Services.Interfaces.BookingService;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO) {
        LoginMessage loginMessage = bookingService.bookDesk(bookingDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
