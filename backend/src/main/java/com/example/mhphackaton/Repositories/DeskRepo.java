package com.example.mhphackaton.Repositories;

import com.example.mhphackaton.Entities.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface DeskRepo extends JpaRepository<Desk, Integer> {
    Desk getById(int id);
}
