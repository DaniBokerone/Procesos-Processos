package com.project;

import java.util.concurrent.ConcurrentHashMap;

class AddMoneyOpperation implements Runnable {
    private final ConcurrentHashMap<String, Integer> compte;

    public AddMoneyOpperation(ConcurrentHashMap<String, Integer> compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        System.out.println("-Ingresant salari-");
        // Simular la adición de dinero a la cuenta
        Integer salariActual = compte.get("salari");
        if (salariActual != null) {
            Integer nouSalari = salariActual + 80;
            compte.put("salari", nouSalari);
            System.out.println("S'ha afegit al sou els plus: " + nouSalari);
        }
    }
}