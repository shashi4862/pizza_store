package com.pizzeria.service;

import org.springframework.stereotype.Service;

import com.pizzeria.dto.NotificationRequest;

@Service
public class NotificationService {

    public String sendNotification(NotificationRequest request) {
        // For now, simulate sending message
        System.out.println("Sending notification to " + request.getEmail() + ": " + request.getMessage());
        return "Notification sent successfully";
    }
}
