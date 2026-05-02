package com.example.realtime_ecommerce_microservices_platform.service;

import com.example.realtime_ecommerce_microservices_platform.Repository.UserRepository;
import com.example.realtime_ecommerce_microservices_platform.dtos.RegisterRequest;
import com.example.realtime_ecommerce_microservices_platform.entity.User;
import com.example.realtime_ecommerce_microservices_platform.security.JwtUtil;
import lombok.RequiredArgsConstructor;
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
        user.setRole("USER");

        userRepository.save(user);

        return jwtUtil.generateToken(user.getEmail());
    }

}