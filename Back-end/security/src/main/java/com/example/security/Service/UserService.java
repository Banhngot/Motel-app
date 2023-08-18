package com.example.Security.Service;

import com.example.Security.Entity.Role;
import com.example.Security.Entity.User;


public interface UserService {
    User saveUser(User user);
    Role savaRole(Role role);
    void addToUser(String username, String rolename);
}
