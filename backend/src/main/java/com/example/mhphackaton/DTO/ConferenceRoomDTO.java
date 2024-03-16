package com.example.mhphackaton.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomDTO {
    private int id;
    private String name;
    private Long officeFloorId;

    @Override
    public String toString() {
        return "ConferenceRoomDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeFloorId=" + officeFloorId +
                '}';
    }
}
