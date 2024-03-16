package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.DTO.ConferenceRoomDTO;
import com.example.mhphackaton.Services.Interfaces.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/conference")
public class ConferenceRoomController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @PostMapping(path="/add_conference")
    public String addConferenceRoom(@RequestBody ConferenceRoomDTO conferenceRoomDTO) {return conferenceRoomService.addConferenceRoom(conferenceRoomDTO); }
}
