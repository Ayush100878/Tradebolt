package com.example.tradebolt.repository;

import com.example.tradebolt.Modal.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepositry extends JpaRepository<OrderItem, Long> {
}
