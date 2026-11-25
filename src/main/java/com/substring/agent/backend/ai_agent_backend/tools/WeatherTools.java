package com.substring.agent.backend.ai_agent_backend.tools;

import org.springframework.stereotype.Component;
import org.springframework.ai.tool.annotation.Tool;

@Component 
public class WeatherTools {

    // getForecast
    //apis to get forecast
    
    @Tool(
        name = "getForecast",
        description = "Get the weather forecast for a specific city and date. Returns temperature, weather conditions, and humidity information."
    )
    public String getForecast(String city, String date) {
        return city + " on " + date + ": 310c, light rain, humidity 78%";

    }


}
