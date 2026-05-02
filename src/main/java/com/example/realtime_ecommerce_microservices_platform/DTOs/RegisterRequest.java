package com.example.realtime_ecommerce_microservices_platform.DTOs;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
