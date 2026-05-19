package com.example.realtime_ecommerce_microservices_platform.testcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "User dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Admin dashboard";
    }

}