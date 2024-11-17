package com.tiketing.models;

import com.tiketing.logging.LoggerUtil;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;

    public Customer(TicketPool ticketPool, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < retrievalRate; i++) {
                    ticketPool.removeTicket();
                }
                LoggerUtil.logInfo(retrievalRate + " tickets purchased by Customer.");
                Thread.sleep(1000); // Simulate delay between purchases
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Customer interrupted: " + e.getMessage());
            LoggerUtil.logError("Customer thread interrupted.", e);

        }
    }
}