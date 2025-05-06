package com.example.tradebolt.repository;

import com.example.tradebolt.Modal.Order;
import com.example.tradebolt.service.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
