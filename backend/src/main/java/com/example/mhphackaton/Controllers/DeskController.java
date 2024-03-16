package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.DTO.DeskDTO;
import com.example.mhphackaton.Services.Interfaces.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/desk")
public class DeskController {
    @Autowired
    private DeskService deskService;

    @PostMapping(path="/add_desk")
    public String addDesk(@RequestBody DeskDTO deskDTO) {return deskService.addDesk(deskDTO); }
}
