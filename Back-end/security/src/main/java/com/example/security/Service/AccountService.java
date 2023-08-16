package com.example.security.Service;

import com.example.security.Entity.Account;
import com.example.security.Entity.Role;

public interface AccountService {
    Account saveAccount(Account account);
    Role saveRole(Role role);
    void addToAccount(String username, String rolename);
}
