package org.ffernandez.threads.ejemplos.executor;

import java.sql.SQLOutput;
import java.util.concurrent.*;


public class ExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Iniciando tarea");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finalizando tarea");
            return "Resultado de la tarea";
        };
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del main");

        System.out.println("¿La tarea ha finalizado? " + resultado.isDone());

        while (!resultado.isDone()) {
            System.out.println("Ejecutando tarea...");
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(resultado.get());
        System.out.println("¿La tarea ha finalizado? " + resultado.isDone());
    }
}
