package com.example.mhphackaton.Services.Implementations;

import com.example.mhphackaton.Entities.User;
import com.example.mhphackaton.Repositories.UserRepo;
import com.example.mhphackaton.DTO.LoginDTO;
import com.example.mhphackaton.UserAuthentication.LoginMessage;
import com.example.mhphackaton.DTO.UserDTO;
import com.example.mhphackaton.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        if (userRepo.findByEmail(userDTO.getEmail()) == null) {
            User user = new User(
                    userDTO.getId(),
                    userDTO.getUsername(),
                    userDTO.getEmail(),
                    this.passwordEncoder.encode(userDTO.getPassword())

            );
            userRepo.save(user);
            return user.getUsername();
        }
        return null;
    }

    UserDTO userDTO;
    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if(user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean samePwd = passwordEncoder.matches(password, encodedPassword);
            if(samePwd) {
                Optional<User> user1 = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(user1.isPresent()) {
                    return new LoginMessage("Login success", true);
                }
                else {
                    return new LoginMessage("Login failed", false);
                }
            }
            else {
                return new LoginMessage("Password not match", false);
            }
        }
        else {
            return new LoginMessage("Email not exist", false);
        }
    }


}
