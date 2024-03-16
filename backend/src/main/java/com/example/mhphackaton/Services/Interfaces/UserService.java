package com.example.mhphackaton.Services.Interfaces;

import com.example.mhphackaton.DTO.LoginDTO;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import com.example.mhphackaton.DTO.UserDTO;


public interface UserService {
    String addUser(UserDTO employeeDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
}
