package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

		// Crear un executor amb un pool de 2 fils
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Task(1));
        executor.execute(new CheckNetwork(1));

        // Tancar l'executor
        executor.shutdown();
    }
}
