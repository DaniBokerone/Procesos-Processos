package com.project;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        
        //Tasca validacio de dades
        CompletableFuture<String> validationFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Validant informacio del usuari...");
            return "Dades valides";
        });

        //Tasca procesament de dades
        CompletableFuture<String> processingFuture = validationFuture.thenApply(validData -> {
            System.out.println("Procesant informacion...");
            return validData + " | Informacio procesada";
        });

        //Tasca mostrar de dades
        CompletableFuture<Void> displayFuture = processingFuture.thenAccept(result -> {
            System.out.println("Resultat del procesament de dades de l'usuari: " + result);
        });

        // Esperar a que finalitzin les operacions
        displayFuture.join();
        System.out.println("Proceso completado.");
    }
}
