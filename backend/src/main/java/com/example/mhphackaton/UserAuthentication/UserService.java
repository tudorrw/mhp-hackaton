package com.example.mhphackaton.UserAuthentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface UserService {
    String addUser(UserDTO employeeDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
}
