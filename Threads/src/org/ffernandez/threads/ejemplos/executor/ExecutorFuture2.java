package org.ffernandez.threads.ejemplos.executor;

import java.util.concurrent.*;


public class ExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());


        Callable<String> tarea = () -> {
            System.out.println("Iniciando tarea 1 y 2");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finalizando tarea");
            return "Resultado de la tarea";
        };

        Callable<Integer> tarea2 = () ->{

            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(4);
            return 10;
        };





        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continuando con la ejecución del main");

        System.out.println("¿La tarea ha finalizado? " + resultado.isDone());

        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())) {
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone() ? "Finalizado" : "En proceso",
                    resultado2.isDone() ? "Finalizado" : "En proceso",
                    resultado3.isDone() ? "Finalizado" : "En proceso"));
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Resultado 1 " + resultado.get());
        System.out.println("Resultado 2 " + resultado2.get());
        System.out.println("Resultado 3 " + resultado3.get());
        System.out.println("¿La tarea ha finalizado? " + resultado.isDone());
    }
}
