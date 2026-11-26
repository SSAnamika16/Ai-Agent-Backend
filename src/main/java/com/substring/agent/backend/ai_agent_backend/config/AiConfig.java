package com.substring.agent.backend.ai_agent_backend.config;


import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.ai.chat.client.ChatClient;
import com.substring.agent.backend.ai_agent_backend.tools.OrderTools;
import com.substring.agent.backend.ai_agent_backend.tools.InventoryTools;
import com.substring.agent.backend.ai_agent_backend.tools.FlightTools;
import com.substring.agent.backend.ai_agent_backend.tools.WeatherTools;
import com.substring.agent.backend.ai_agent_backend.tools.HotelTools;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;

import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class AiConfig {

    private final OrderTools tools;
    private final InventoryTools inventoryTools;
    private final FlightTools flightTools;
    private final WeatherTools weatherTools;
    private final HotelTools hotelTools;


    @Bean 
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory
            .builder()
            .maxMessages(10)
            .build();
    }




    @Bean
    public ChatClient chatClient(  ChatClient.Builder builder) {
        return builder
             .defaultSystem("""
                You are a helpful travel planning agent and helpful customer support agent for an online store.
                Use the available tools to find flights, hotels, and weather forecasts for users.
                When given a budget, suggest options that fit within it and explain your reasoning.
                """)
        
        // .defaultSystem("""
        //     You are a helpful assistant for a travel booking application. You can assist users with searching and booking flights and hotels, as well as providing weather forcasts for specific locations. You have access to the following tools: 
        //     1. FlightTools: Use this tool to search for flights based on source, destination, and date. It returns a list of available flights with their prices.
        //     2. HotelTools: Use this tool to search for hotels based on city and maximum price per night. It returns a list of available hotels with their prices and ratings.   
        //     3. WeatherTools: Use this tool to get the weather forecast for a specific city and date. It returns temperature, weather conditions, and humidity information.
        //     4. OrderTools: Use this tool to manage customer orders, including creating, updating, and retrieving order details.
        //     5. InventoryTools: Use this tool to manage product inventory, including checking stock levels and updating product information.
        //     """)

        .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory()).build())
        .defaultTools(tools, inventoryTools, flightTools, weatherTools, hotelTools)
        .build();
    }

    
}
