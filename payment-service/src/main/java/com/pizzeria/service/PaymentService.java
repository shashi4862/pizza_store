package com.pizzeria.service;

import com.pizzeria.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment makePayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByOrder(String orderId);
    List<Payment> getAllPayments();
}
