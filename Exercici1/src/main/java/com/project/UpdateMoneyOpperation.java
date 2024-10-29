package com.project;

import java.util.concurrent.ConcurrentHashMap;

class UpdateMoneyOpperation implements Runnable {
    private final ConcurrentHashMap<String, Integer> compte;

    public UpdateMoneyOpperation(ConcurrentHashMap<String, Integer> compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        System.out.println("-Restant impostos del salari-");
        Integer salariActual = compte.get("salari");
        if (salariActual != null) {
            Integer nouSalari = salariActual - 50; 
            compte.put("salari", nouSalari);
            System.out.println("S'han restat del salari els impostos: " + nouSalari);
        }
    }
}