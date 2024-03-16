package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.OfficeFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface OfficeFloorRepo extends JpaRepository<OfficeFloor, Integer> {
    OfficeFloor getById(int id);
}
