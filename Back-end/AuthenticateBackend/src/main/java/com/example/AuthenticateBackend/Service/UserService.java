package com.example.AuthenticateBackend.Service;

import com.example.AuthenticateBackend.Modles.ApplicationUser;
import com.example.AuthenticateBackend.Modles.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        if(!username.equals("Hoang")) throw new UsernameNotFoundException("Not Hoang");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"user"));
        return new ApplicationUser(1,"Hoang",encoder.encode("password"),roles);
    }
}
