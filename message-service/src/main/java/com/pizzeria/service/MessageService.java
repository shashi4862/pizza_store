package com.pizzeria.service;

import com.pizzeria.entity.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Message message);
    List<Message> getMessagesByUser(String email);
    List<Message> getAllMessages();
}
