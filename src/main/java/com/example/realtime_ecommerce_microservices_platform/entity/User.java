package com.example.realtime_ecommerce_microservices_platform.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private String role;

}
