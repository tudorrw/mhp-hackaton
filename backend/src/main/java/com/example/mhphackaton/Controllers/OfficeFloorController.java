package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.Entities.OfficeFloor;
import com.example.mhphackaton.Services.Interfaces.OfficeFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/of")
public class OfficeFloorController {
    @Autowired
    private OfficeFloorService officeFloorService;
    @GetMapping("/floors")
    @ResponseBody
    List<OfficeFloor> seeFloors() {
        return officeFloorService.getOfficeFloors();
    }

}
