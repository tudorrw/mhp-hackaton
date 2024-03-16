package com.example.mhphackaton.Services.Implementations;

import com.example.mhphackaton.Entities.OfficeFloor;
import com.example.mhphackaton.Repositories.OfficeFloorRepo;
import com.example.mhphackaton.Services.Interfaces.OfficeFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeFloorImpl implements OfficeFloorService {
    @Autowired
    private OfficeFloorRepo officeFloorRepo;
    @Override
    public List<OfficeFloor> getOfficeFloors() {
        return officeFloorRepo.findAll();
    }
}
