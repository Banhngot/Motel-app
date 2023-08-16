package com.example.security;

import com.example.security.Entity.Account;
import com.example.security.Entity.Role;
import com.example.security.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder brCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(AccountService accountService){
		return args -> {
			accountService.saveRole(new Role(3,"ROLE_HOUSE_OWNER"));
			accountService.saveRole(new Role(2,"ROLE_RENTER"));
			accountService.saveRole(new Role(1,"ROLE_ADMIN"));

			accountService.saveAccount(new Account(1,"admin","123",new HashSet<>()));
			accountService.saveAccount(new Account(2,"test1","123",new HashSet<>()));
			accountService.saveAccount(new Account(3,"test2","123",new HashSet<>()));

			accountService.addToAccount("admin","ROLE_ADMIN");
			accountService.addToAccount("test1","ROLE_HOUSE_OWNER");
			accountService.addToAccount("test2","ROLE_RENTER");
		};
	}

}
