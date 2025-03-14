package com.example.auth_service.repository;

import com.example.auth_service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUsername(String username);

    @Query("SELECT id FROM Admin WHERE username = :username")
    Integer findAdminIdByUsername(String username);
}
