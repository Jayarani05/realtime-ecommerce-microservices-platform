package com.example.realtime_ecommerce_microservices_platform.conroller;

import com.example.realtime_ecommerce_microservices_platform.dtos.OrderRequest;
import com.example.realtime_ecommerce_microservices_platform.entity.Order;
import com.example.realtime_ecommerce_microservices_platform.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create(
            @RequestBody OrderRequest request){

        return orderService.createOrder(request);
    }

    @GetMapping
    public List<Order> getOrders(){

        return orderService.getAllOrders();
    }
}