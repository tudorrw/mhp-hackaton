package com.example.mhphackaton.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomBookingDTO {
    private int userId;
    private int conferenceRoomId;
    private LocalDate date;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "ConferenceRoomBookingDTO{" +
                "userId=" + userId +
                ", deskId=" + conferenceRoomId +
                ", date=" + date +
                ", createdAt=" + createdAt +
                '}';
    }
}
