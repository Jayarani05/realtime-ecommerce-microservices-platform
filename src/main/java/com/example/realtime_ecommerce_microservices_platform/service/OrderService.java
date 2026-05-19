package com.example.realtime_ecommerce_microservices_platform.service;

import com.example.realtime_ecommerce_microservices_platform.Repository.OrderRepository;
import com.example.realtime_ecommerce_microservices_platform.dtos.OrderRequest;
import com.example.realtime_ecommerce_microservices_platform.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order createOrder(OrderRequest request){

        Order order=new Order();

        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setAmount(request.getAmount());

        order.setStatus("CREATED");

        return repository.save(order);
    }

    public List<Order> getAllOrders(){

        return repository.findAll();
    }
}