package com.example.realtime_ecommerce_microservices_platform.Repository;

import com.example.realtime_ecommerce_microservices_platform.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
        extends JpaRepository<Order,Long> {

}