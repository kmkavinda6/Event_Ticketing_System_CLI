package com.tiketing.config;

import java.util.Scanner;

public class ConfigManager {
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

        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }
}