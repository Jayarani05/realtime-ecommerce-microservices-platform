package com.example.realtime_ecommerce_microservices_platform.service;

import com.example.realtime_ecommerce_microservices_platform.Repository.UserRepository;
import com.example.realtime_ecommerce_microservices_platform.dtos.LoginRequest;
import com.example.realtime_ecommerce_microservices_platform.dtos.RegisterRequest;
import com.example.realtime_ecommerce_microservices_platform.entity.Role;
import com.example.realtime_ecommerce_microservices_platform.entity.User;
import com.example.realtime_ecommerce_microservices_platform.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole("USER");
        user.setRole(Role.USER);

        userRepository.save(user);

        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}