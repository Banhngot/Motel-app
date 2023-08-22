package com.example.Security.Controller;

import com.example.Security.Auth.AuthenticationRequest;
import com.example.Security.Auth.AuthenticationResponse;
import com.example.Security.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final AuthenticationService authenticationService;

    @GetMapping("/test")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Authentication and Authorization is succeed");
    }
}
