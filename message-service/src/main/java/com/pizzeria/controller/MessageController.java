package com.pizzeria.controller;

import com.pizzeria.entity.Message;
import com.pizzeria.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Message>> getMessagesByUser(@PathVariable String email){
        return ResponseEntity.ok(messageService.getMessagesByUser(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}
