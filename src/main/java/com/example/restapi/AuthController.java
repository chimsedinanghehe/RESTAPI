package com.example.restapi;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager) {
        this.authManager = authManager;
        this.jwtUtil = new JwtUtil();
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .get()
                .getAuthority()
                .replace("ROLE_", "");

        String token = jwtUtil.generateToken(userDetails.getUsername(), role);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return result;
    }


}
