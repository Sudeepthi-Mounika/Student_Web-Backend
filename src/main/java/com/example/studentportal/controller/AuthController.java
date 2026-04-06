package com.example.studentportal.controller;

import com.example.studentportal.entity.User;
import com.example.studentportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public Object signup(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail().toLowerCase());

        if (existingUser.isPresent()) {
            return Map.of("message", "Email already registered");
        }

        user.setEmail(user.getEmail().toLowerCase());
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email").toLowerCase();
        String password = loginData.get("password");

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }

        return Map.of("message", "Invalid email or password");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}