package com.substring.agent.backend.ai_agent_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.substring.agent.backend.ai_agent_backend.service.ChatService;



@RestController 
@RequestMapping ("/chat")
@RequiredArgsConstructor 
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<String> chat(@RequestBody String message) {

        return ResponseEntity.ok(chatService.chat(message));

        // String response = "You said: " + message;
        // return ResponseEntity.ok(response);

    }

    
}
