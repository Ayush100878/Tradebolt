package com.example.tradebolt.service;

import com.example.tradebolt.Modal.Coin;
import com.example.tradebolt.Modal.Order;
import com.example.tradebolt.Modal.OrderItem;
import com.example.tradebolt.Modal.User;
import com.example.tradebolt.domain.OrderType;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long ordrId) throws Exception;

    List<Order> getAllOrdersForUser(Long userId, OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
}
