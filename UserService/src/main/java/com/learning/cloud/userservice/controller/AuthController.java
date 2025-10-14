package com.learning.cloud.userservice.controller;

import com.learning.cloud.userservice.dto.LoginRequest;
import com.learning.cloud.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok().body(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {

        authService.logout();

        return ResponseEntity.ok().body("Logged out successfully");
    }
}
