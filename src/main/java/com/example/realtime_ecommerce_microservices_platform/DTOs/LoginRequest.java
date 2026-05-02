package com.example.realtime_ecommerce_microservices_platform.DTOs;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
