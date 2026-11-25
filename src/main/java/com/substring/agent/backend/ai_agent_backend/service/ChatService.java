package com.substring.agent.backend.ai_agent_backend.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;

@Service 
@RequiredArgsConstructor 
public class ChatService {

    private final ChatClient chatClient;
    

    public String chat(String query) {

     String response = chatClient
        .prompt()
        .user(query)
        .call()
        .content();

        return response;

        
    }

}
