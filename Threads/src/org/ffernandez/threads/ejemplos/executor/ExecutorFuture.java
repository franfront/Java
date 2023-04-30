package org.ffernandez.threads.ejemplos.executor;

import java.sql.SQLOutput;
import java.util.concurrent.*;


public class ExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Iniciando tarea");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finalizando tarea");
        };
        Future<?> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del main 1");

        System.out.println("¿La tarea ha finalizado? " + resultado.isDone());
        System.out.println(resultado.get());
    }
}
