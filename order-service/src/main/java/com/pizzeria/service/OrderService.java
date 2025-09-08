package com.pizzeria.service;

import com.pizzeria.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);
    Order cancelOrder(Long id);
    Order getOrderById(Long id);
    List<Order> getOrdersByUser(String email);
    List<Order> getAllOrders();
    Order updateStatus(Long id, String status);
}
