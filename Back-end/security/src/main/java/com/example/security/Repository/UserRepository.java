package com.example.Security.Repository;

import com.example.Security.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Role, Long> {
}
