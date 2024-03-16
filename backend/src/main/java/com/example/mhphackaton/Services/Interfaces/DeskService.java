package com.example.mhphackaton.Services.Interfaces;

import com.example.mhphackaton.DTO.DeskDTO;
import com.example.mhphackaton.Entities.Desk;

import java.util.List;

public interface DeskService {
    List<Desk> getAllDesks();
    String addDesk(DeskDTO deskDTO);

}
