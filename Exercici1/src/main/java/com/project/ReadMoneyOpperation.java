package com.project;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

class ReadMoneyOpperation implements Callable<Integer> {
    private final ConcurrentHashMap<String, Integer> compte;

    public ReadMoneyOpperation(ConcurrentHashMap<String, Integer> compte) {
        this.compte = compte;
    }

    @Override
    public Integer call() {
        System.out.println("-Salari actual-");
        return compte.get("salari");
    }
}