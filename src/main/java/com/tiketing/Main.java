package com.tiketing;


import com.tiketing.config.ConfigManager;
import com.tiketing.config.Configuration;
import com.tiketing.models.Customer;
import com.tiketing.models.TicketPool;
import com.tiketing.models.Vendor;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Configuration config;

        try {
            // Try to load configuration from file
            config = ConfigManager.loadFromFile("config.json");
            System.out.println("Configuration loaded successfully.");
        } catch (IOException e) {
            System.out.println("No configuration file found. Creating new configuration.");
            config = ConfigManager.setupConfiguration();

            // Save the new configuration
            try {
                ConfigManager.saveToFile(config, "config.json");
                System.out.println("Configuration saved successfully.");
            } catch (IOException saveError) {
                System.out.println("Error saving configuration: " + saveError.getMessage());
            }
        }

        // Initialize the ticketing system
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Create and start vendor threads
        for (int i = 0; i < 2; i++) {
            new Thread(new Vendor(ticketPool, config.getTicketReleaseRate())).start();
        }

        // Create and start customer threads
        for (int i = 0; i < 5; i++) {
            new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate())).start();
        }
    }
}