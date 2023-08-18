package com.example.security.Service;

import com.example.security.Auth.AuthenticationRequest;
import com.example.security.Auth.AuthenticationResponse;
import com.example.security.Entity.Account;
import com.example.security.Entity.Role;
import com.example.security.Repository.AccountRepo;
import com.example.security.Repository.RoleCustomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountRepo accountRepo;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepo roleCustomRepo;
    private final jwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        Account account = accountRepo.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        List<Role> role = null;
        if(account!=null){
            role = roleCustomRepo.getRole(account);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> set = new HashSet<>();
        role.stream().forEach(c->set.add(new Role(c.getName())));
        account.setRoles(set);
        set.stream().forEach(i->authorities.add(new SimpleGrantedAuthority(i.getName())));
        var jwtToken = jwtService.generateToken(account, authorities);
        var jwtRefreshToken = jwtService.generateRefreshToken(account, authorities);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
