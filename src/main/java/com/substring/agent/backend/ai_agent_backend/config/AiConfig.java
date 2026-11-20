package com.substring.agent.backend.ai_agent_backend.config;


import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.ai.chat.client.ChatClient;
import com.substring.agent.backend.ai_agent_backend.tools.OrderTools;

import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class AiConfig {

    private final OrderTools tools;


    @Bean
    public ChatClient chatClient(  ChatClient.Builder builder) {
        return builder
        .defaultSystem("""
            You are a helpful assistant that helps users to get the status of their orders and cancel their orders.
            """)
        .defaultTools(tools)
        .build();
    }

    
}
