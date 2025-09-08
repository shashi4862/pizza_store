package com.pizzeria.service;

import com.pizzeria.entity.Order;
import com.pizzeria.exception.CustomException;
import com.pizzeria.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setTrackingNumber("TRK-" + System.currentTimeMillis());
        return orderRepository.save(order);
    }

    @Override
    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException("Order not found"));
        if(!order.getStatus().equals("PENDING")){
            throw new CustomException("Only pending orders can be cancelled");
        }
        order.setStatus("CANCELLED");
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByUser(String email) {
        return orderRepository.findByUserEmail(email);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
