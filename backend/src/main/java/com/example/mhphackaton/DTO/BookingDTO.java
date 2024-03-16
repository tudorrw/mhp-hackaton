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
public class BookingDTO {
    private int userId;
    private int deskId;
    private LocalDate date;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "BookingDTO{" +
                "userId=" + userId +
                ", deskId=" + deskId +
                ", date=" + date +
                ", createdAt=" + createdAt +
                '}';
    }
}


