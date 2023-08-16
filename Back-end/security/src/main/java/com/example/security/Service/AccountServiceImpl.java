package com.example.security.Service;

import com.example.security.Entity.Account;
import com.example.security.Entity.Role;
import com.example.security.Repository.AccountRepo;
import com.example.security.Repository.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addToAccount(String username, String rolename) {
        Account account = accountRepo.findByUsername(username);
        Role role = roleRepo.findByName(rolename);
        account.getRoles().add(role);
    }
}
