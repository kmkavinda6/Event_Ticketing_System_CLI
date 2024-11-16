package com.tiketing;

import com.tiketing.config.ConfigManager;
import com.tiketing.config.Configuration;
import com.tiketing.models.Customer;
import com.tiketing.models.TicketPool;
import com.tiketing.models.Vendor;

public class Main {
    public static void main(String[] args) {
        // Configure the system
        Configuration config = ConfigManager.setupConfiguration();

        // Initialize ticket pool
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Create and start vendor threads
        for (int i = 0; i < 2; i++) { // Assume 2 vendors
            new Thread(new Vendor(ticketPool, config.getTicketReleaseRate())).start();
        }

        // Create and start customer threads
        for (int i = 0; i < 5; i++) { // Assume 5 customers
            new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate())).start();
        }
    }
}
