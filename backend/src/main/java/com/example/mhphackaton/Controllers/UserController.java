package com.example.mhphackaton.Controllers;

import com.example.mhphackaton.Services.Interfaces.UserService;
import com.example.mhphackaton.DTO.LoginDTO;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import com.example.mhphackaton.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path="/register")
    public String addUser(@RequestBody UserDTO userDTO)
    {
        return userService.addUser(userDTO);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
