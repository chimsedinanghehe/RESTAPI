package com.example.restapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public UserService() {
        // Demo: tạo sẵn 2 user
        users.add(new User("user", "123456", Role.USER));
        users.add(new User("admin", "123456", Role.ADMIN));
    }

    public Optional<User> getByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public boolean validateCredentials(String username, String password) {
        return getByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String username, User updatedUser) {
        getByUsername(username).ifPresent(u -> {
            u.setPassword(updatedUser.getPassword());
            u.setRole(updatedUser.getRole());
        });
    }

    public void deleteUser(String username) {
        getByUsername(username).ifPresent(users::remove);
    }
}
