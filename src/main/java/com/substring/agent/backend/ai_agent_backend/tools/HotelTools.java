package com.substring.agent.backend.ai_agent_backend.tools;

import org.springframework.stereotype.Component;
import com.substring.agent.backend.ai_agent_backend.model.Hotel;
import java.util.List;
import org.springframework.ai.tool.annotation.Tool;

@Component 
public class HotelTools {

    private final List<Hotel> hotels = List.of(
        new Hotel("The Grand Palace", "New York", 15000, 4.5),
        new Hotel("Ocean View Resort", "Miami", 12000, 4.2),
        new Hotel("Mountain Retreat", "Denver", 10000, 4.0),
        new Hotel("City Lights Hotel", "Los Angeles", 13000, 4.3),
        new Hotel("Lakeside Inn", "Chicago", 11000, 4.1)
    );

    //search hotel
    //apis to search hotel

    @Tool(
        name = "searchHotel",
        description = "Search for hotels based on city and maximum price per night. Returns a list of available hotels with their prices and ratings."
    )
    public String searchHotel(String city, int maxPrice) {
        StringBuilder result = new StringBuilder();
        for(Hotel hotel : hotels) {
            if(hotel.city().equalsIgnoreCase(city) && hotel.pricePerNightINR() <= maxPrice) {
                result.append("Hotel Name: ").append(hotel.name())
                      .append(", Price per Night: ").append(hotel.pricePerNightINR())
                      .append(", Rating: ").append(hotel.rating()).append(", ");
            }
        }
        return result.length() > 0 ? result.toString() : "No hotels found for the given criteria.";
    }


    //hotel status

    //hotel booking
    
}
