package com.example.auth_service.service;

import com.example.auth_service.model.Admin;
import com.example.auth_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

    public String loginAdmin(String username) {
        String userId = adminRepository.findAdminIdByUsername(username).toString();
        System.out.println(userId);
        return jwtService.generateToken(userId);
    }

    public boolean validateToken(String token) {
        return jwtService.validateToken(token);
    }
}
