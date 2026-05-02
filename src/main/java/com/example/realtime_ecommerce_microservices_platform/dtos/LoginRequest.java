package com.example.realtime_ecommerce_microservices_platform.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
