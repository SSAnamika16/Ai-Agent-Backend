package com.substring.agent.backend.ai_agent_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.substring.agent.backend.ai_agent_backend.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController 
@RequestMapping ("/chat")
@RequiredArgsConstructor 
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<String> chat(@RequestHeader("Conversation-Id") String conversationId, @RequestBody String message) {

        return ResponseEntity.ok(chatService.chat(message, conversationId));

        // String response = "You said: " + message;
        // return ResponseEntity.ok(response);

    }

    
}
