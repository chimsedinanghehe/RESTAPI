package com.example.restapi.controller;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    private boolean isAdmin(String token) {
        return jwtUtils.getRoleFromJwt(token).equals("ADMIN");
    }

    private String getUsername(String token) {
        return jwtUtils.getUsernameFromJwt(token);
    }

    private String extractToken(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // cắt "Bearer " ra
        }
        return header;
    }

    @GetMapping
    public List<User> getAllUsers(@RequestHeader("Authorization") String token) {
        token = extractToken(token);
        if (!isAdmin(token)) throw new RuntimeException("Access denied");
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        token = extractToken(token);
        if (!isAdmin(token)) throw new RuntimeException("Access denied");
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestHeader("Authorization") String token,
                           @PathVariable Long id,
                           @RequestBody User userDetails) {
        token = extractToken(token);
        String username = getUsername(token);
        User user = userRepository.findById(id).orElseThrow();
        if (!isAdmin(token) && !user.getUsername().equals(username)) {
            throw new RuntimeException("Access denied");
        }
        user.setUsername(userDetails.getUsername());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword());
        }
        return userRepository.save(user);
    }

    @PostMapping
    public User createUser(@RequestHeader("Authorization") String token,
                           @RequestBody User newUser) {
        token = extractToken(token);
        if (!isAdmin(token)) throw new RuntimeException("Access denied");
        return userRepository.save(newUser);
    }



}
