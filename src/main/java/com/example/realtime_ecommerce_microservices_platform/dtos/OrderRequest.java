package com.example.realtime_ecommerce_microservices_platform.dtos;

import lombok.Data;

@Data
public class OrderRequest {

    private Long userId;

    private Long productId;

    private Integer quantity;

    private Double amount;
}