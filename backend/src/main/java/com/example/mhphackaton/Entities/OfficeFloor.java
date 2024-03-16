package com.example.mhphackaton.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="office_floor")
public class OfficeFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

