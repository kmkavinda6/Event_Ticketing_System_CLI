package com.tiketing.config;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigManager {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Configuration setupConfiguration() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total tickets: ");
        int totalTickets = scanner.nextInt();

        System.out.print("Enter ticket release rate: ");
        int ticketReleaseRate = scanner.nextInt();

        System.out.print("Enter customer retrieval rate: ");
        int customerRetrievalRate = scanner.nextInt();

        System.out.print("Enter maximum ticket capacity: ");
        int maxTicketCapacity = scanner.nextInt();

        scanner.close();
        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    public static void saveToFile(Configuration config, String fileName) throws IOException {
        mapper.writeValue(new File(fileName), config);
    }

    public static Configuration loadFromFile(String fileName) throws IOException {
        return mapper.readValue(new File(fileName), Configuration.class);
    }
}
