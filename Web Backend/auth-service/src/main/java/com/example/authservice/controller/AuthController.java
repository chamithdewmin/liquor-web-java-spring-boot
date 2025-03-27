package com.example.authservice.controller;

import com.example.authservice.dto.AuthRequest;
import com.example.authservice.model.UserCredential;
import com.example.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserCredential userCredential) {
        try {
            authService.saveUser(userCredential);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "success", true,
                            "message", "User saved successfully"
                    ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "success", false,
                            "message", e.getMessage()
                    ));
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            System.out.println("Username: " + authRequest.getUsername());
            System.out.println("Password: " + authRequest.getPassword());

            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            if (authenticate.isAuthenticated()) {
                String token = authService.loginUser(authRequest.getUsername());
                String userId = authService.getUserIdFromToken(token);
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "User authenticated successfully",
                        "token", token,
                        "userId", userId
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "success", false,
                                "message", "Invalid credentials"
                        ));
            }
        } catch (Exception e) {
            System.out.println("Error:" +e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "success", false,
                            "message", "Invalid credentials"
                    ));
        }
    }


    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        try {
            boolean isValid = authService.validateToken(token);
            if (isValid) {
                String userId = authService.getUserIdFromToken(token);
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Token is valid",
                        "userId", userId
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "success", false,
                                "message", "Token is invalid"
                        ));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "success", false,
                            "message", "Invalid token format",
                            "error", e.getMessage()
                    ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "success", false,
                            "message", "Error validating token",
                            "error", e.getMessage()
                    ));
        }
    }

    @GetMapping("/email/{userId}")
    public ResponseEntity<?> getEmail(@PathVariable String userId) {
        try {
            String email = authService.getEmail(userId);
            return ResponseEntity.ok(Map.of(
                    "email", email
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "success", false,
                            "message", "Error fetching email",
                            "error", e.getMessage()
                    ));
        }
    }


}

