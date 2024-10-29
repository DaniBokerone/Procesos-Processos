package com.project;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

		// Crear un executor amb un pool de 3 fils
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //Crear compte del banc
        ConcurrentHashMap<String, Integer> compte = new ConcurrentHashMap<>();
        compte.put("salari", 1250);

        //Creacio de tasques
        Runnable afegirSalari = new AddMoneyOpperation(compte);
        Runnable updateSalari = new UpdateMoneyOpperation(compte);
        Callable<Integer> mostrarSalari = new ReadMoneyOpperation(compte);

        executor.execute(afegirSalari);
        executor.execute(updateSalari);

        //Esperem que acabin les tasques
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Utilitzar el callable despres de realitzar les tasques per a veure el resultat
        Future<Integer> salariFinalFuture = executor.submit(mostrarSalari);

        try {
            Integer salariFinal = salariFinalFuture.get();
            System.out.println("El salari final es: " + salariFinal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tancar l'executor
        executor.shutdown();
    }
}
