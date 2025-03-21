package com.example.authservice.repository;

import com.example.authservice.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    @Query("SELECT id FROM Admin WHERE username = :username")
    Integer findAdminIdByUsername(String username);

}



