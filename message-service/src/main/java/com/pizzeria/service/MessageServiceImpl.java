package com.pizzeria.service;

import com.pizzeria.entity.Message;
import com.pizzeria.exception.CustomException;
import com.pizzeria.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        message.setCreatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByUser(String email) {
        return messageRepository.findByUserEmail(email);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
