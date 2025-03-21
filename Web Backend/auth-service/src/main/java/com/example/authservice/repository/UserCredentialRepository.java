package com.example.authservice.repository;

import com.example.authservice.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByUsername(String username);

    @Query("SELECT id FROM UserCredential WHERE username = :username")
    Integer findUserIdByUsername(String username);

    @Query("SELECT email FROM UserCredential WHERE id = :userId")
    String findEmailByUserId(int userId);
}
