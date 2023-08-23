package com.example.AuthenticateBackend.Controller;

import com.example.AuthenticateBackend.Modles.ApplicationUser;
import com.example.AuthenticateBackend.Modles.LoginResponseDTO;
import com.example.AuthenticateBackend.Modles.RegistrationDTO;
import com.example.AuthenticateBackend.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(),body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(),body.getPassword());
    }

}
