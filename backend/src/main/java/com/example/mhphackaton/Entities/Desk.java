package com.example.mhphackaton.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="desk")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "office_floor_id")
    private OfficeFloor officeFloor;

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeFloor=" + officeFloor +
                '}';
    }
}
