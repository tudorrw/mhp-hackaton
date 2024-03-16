package com.example.mhphackaton.Services.Implementations;

import com.example.mhphackaton.DTO.DeskDTO;
import com.example.mhphackaton.Entities.Desk;
import com.example.mhphackaton.Repositories.DeskRepo;
import com.example.mhphackaton.Repositories.OfficeFloorRepo;
import com.example.mhphackaton.Services.Interfaces.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskRepo deskRepo;
    @Autowired
    private OfficeFloorRepo officeFloorRepo;

    @Override
    public List<Desk> getAllDesks() {
        return deskRepo.findAll();
    }

    @Override
    public String addDesk(DeskDTO deskDTO) {
        if (!deskRepo.existsById(deskDTO.getId()) && officeFloorRepo.getById(deskDTO.getOfficeFloorId()) != null) {
            Desk desk = new Desk(
                    deskDTO.getId(),
                    deskDTO.getName(),
                    officeFloorRepo.getById(deskDTO.getOfficeFloorId())

            );
            System.out.println(officeFloorRepo.getById(deskDTO.getOfficeFloorId()));
            System.out.println(desk.toString());
            deskRepo.save(desk);
            return desk.getName();
        }
        return null;
    }
}
