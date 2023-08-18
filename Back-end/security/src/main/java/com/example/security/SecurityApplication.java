package com.example.Security;

import com.example.Security.Entity.Role;
import com.example.Security.Entity.User;
import com.example.Security.Service.UserService;
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
	BCryptPasswordEncoder brBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.savaRole(new Role(null,"ROLE_ADMIN"));
			userService.savaRole(new Role(null,"ROLE_HOUSE_OWNER"));
			userService.savaRole(new Role(null,"ROLE_RENTER"));

			userService.saveUser(new User(null,"Hoang","Hoang123","hoang1@gmail.com","123456",new HashSet<>()));
			userService.saveUser(new User(null,"test1","test123","test1@gmail.com","123456",new HashSet<>()));
			userService.saveUser(new User(null,"test2","test1234","test2@gmail.com","123456",new HashSet<>()));

			userService.addToUser("hoang1@gmail.com","ROLE_ADMIN");
			userService.addToUser("test1@gmail.com","ROLE_HOUSE_OWNER");
			userService.addToUser("test2@gmail.com","ROLE_RENTER");
		};
	}

}
