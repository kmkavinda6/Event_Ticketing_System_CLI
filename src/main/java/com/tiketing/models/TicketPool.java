package com.tiketing.models;

import java.util.LinkedList;
import java.util.List;

public class TicketPool {
    private final List<Integer> tickets = new LinkedList<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTickets(int ticketCount) throws InterruptedException {
        while (tickets.size() + ticketCount > maxCapacity) {
            wait(); // Wait until space is available
        }
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(1); // Add tickets (symbolic representation)
        }
        System.out.println(ticketCount + " tickets added. Current pool: " + tickets.size());
        notifyAll(); // Notify waiting consumers
    }

    public synchronized void removeTicket() throws InterruptedException {
        while (tickets.isEmpty()) {
            wait(); // Wait until tickets are available
        }
        tickets.remove(0);
        System.out.println("1 ticket purchased. Current pool: " + tickets.size());
        notifyAll(); // Notify waiting producers
    }
}