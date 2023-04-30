package org.ffernandez.threads.ejemplos.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Executor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Iniciando tarea");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finalizando tarea");
        };
        executor.submit(tarea); // ejecuta la tarea
        executor.shutdown(); // termina el executor
        System.out.println("Continuando con la ejecución del main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS); // espera a que termine el executor
        System.out.println("Continuando con la ejecución del main 2");
    }
}
