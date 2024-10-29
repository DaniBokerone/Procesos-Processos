package com.project;

class CheckNetwork implements Runnable {
    private final int ticketId;

    public CheckNetwork(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public void run() {
        System.out.println("Executant network check for ticket: " + ticketId);
    }
}