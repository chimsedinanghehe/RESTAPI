package com.example.restapi.controller;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent() &&
                passwordEncoder.matches(user.getPassword(), optionalUser.get().getPassword())) {
            return jwtUtils.generateJwtToken(optionalUser.get().getUsername(),
                    optionalUser.get().getRole());
        }
        return "Invalid username/password";
    }
}
