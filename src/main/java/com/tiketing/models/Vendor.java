package com.tiketing.models;

import com.tiketing.logging.LoggerUtil;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    public Vendor(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ticketPool.addTickets(releaseRate);
                LoggerUtil.logInfo(releaseRate + " tickets released by vendor.");
                Thread.sleep(1000); // Simulate delay between releases
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Vendor interrupted: " + e.getMessage());
            LoggerUtil.logError("Vendor thread interrupted.", e);
        }
    }
}