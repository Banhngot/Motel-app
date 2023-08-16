package com.example.security.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleCustomRepo {
    @PersistenceContext
    private EntityManager entityManager;
}
