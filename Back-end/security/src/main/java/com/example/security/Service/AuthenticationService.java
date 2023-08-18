package com.example.security.Service;

import com.example.security.Auth.AuthenticationRequest;
import com.example.security.Auth.AuthenticationResponse;
import com.example.security.Entity.Account;
import com.example.security.Entity.Role;
import com.example.security.Repository.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountRepo accountRepo;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        Account account = accountRepo.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        List<Role> role = null;
        if(account!=null){
            role
        }
    }
}
