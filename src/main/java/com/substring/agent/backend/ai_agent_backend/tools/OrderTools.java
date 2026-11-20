package com.substring.agent.backend.ai_agent_backend.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component 
public class OrderTools {

// fake data:
private final Map<String, String> orders = Map.of(
         "1042", "Shipped - arriving tomorrow",
         "1043", "Processing - not yet shipped",
         "1044", "Cancelled - out of stock",
         "1045", "Shipped - arriving next week"

);

@Tool(description = "Get the status of an customer order by its order ID")
public String getOrderStatus(String orderId) {
    return orders.getOrDefault(orderId, "Order not found");
}

@Tool(description = "Cancel a customer order by its order ID")
public String cancelOrder(String orderId) {
    if(orders.containsKey(orderId)) {
        return "Order " + orderId + "has been cancelled.";
    } else {
        return "Order not found";
    }

}

        
    
}
