package com.example.security.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.security.Entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class jwtService {
    private static final String Secret_ket = "123";
    public String generateToken(Account account, Collection<SimpleGrantedAuthority> authorities){
        Algorithm algorithm = Algorithm.HMAC256(Secret_ket.getBytes());
        return JWT.create()
                .withSubject(account.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() + 50*60*1000))
                .withClaim("role", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
    public String generateRefreshToken(Account account, Collection<SimpleGrantedAuthority> authorities){
        Algorithm algorithm = Algorithm.HMAC256(Secret_ket.getBytes());
        return JWT.create()
                .withSubject(account.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() + 50*60*1000))
                .sign(algorithm);
    }
}
