package com.example.mhphackaton.Services.Implementations;

import com.example.mhphackaton.DTO.ConferenceRoomBookingDTO;
import com.example.mhphackaton.Entities.ConferenceRoomBooking;
import com.example.mhphackaton.Repositories.*;
import com.example.mhphackaton.Services.Interfaces.ConferenceRoomBookingService;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConferenceRoomBookingServiceImpl implements ConferenceRoomBookingService {
    @Autowired
    private ConferenceRoomBookingRepo conferenceRoomBookingRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ConferenceRoomRepo conferenceRoomRepo;

    @Override
    public LoginMessage bookConferenceRoom(ConferenceRoomBookingDTO conferenceRoomBookingDTO) {
        if (isUserAvailableForBooking(conferenceRoomBookingDTO.getUserId(), conferenceRoomBookingDTO.getDate())) {
            // Check if the desk is available for booking
            if (isConferenceRoomAvailable(conferenceRoomBookingDTO.getConferenceRoomId(), conferenceRoomBookingDTO.getDate())) {
                // Create a new booking entity
                ConferenceRoomBooking booking = new ConferenceRoomBooking();
                booking.setId(conferenceRoomBookingDTO.getUserId());
                //TODO
//                booking.setRoom(conferenceRoomRepo.getById(conferenceRoomBookingDTO.getConferenceRoomId()));
                booking.setDate(conferenceRoomBookingDTO.getDate());

                // Save the booking to the database
                //TODO
//                conferenceRoomBookingRepo.save(booking);
                return new LoginMessage("Desk booked successfully.",true);
            } else {
                return new LoginMessage("Desk is not available for booking at the specified date and time.", false);
            }
        } else {
            return new LoginMessage("User already has a booking at the specified date and time.", false);
        }
    }
    private boolean isUserAvailableForBooking(int userId, LocalDate date) {
        return true;
    }
    private boolean isConferenceRoomAvailable(int conferenceRoomId, LocalDate date) {
        return true;
    }
}
