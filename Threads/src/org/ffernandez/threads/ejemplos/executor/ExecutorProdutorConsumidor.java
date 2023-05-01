package org.ffernandez.threads.ejemplos.executor;

import org.ffernandez.threads.ejemplos.sync.Panaderia;
import org.ffernandez.threads.ejemplos.sync.runnable.Cliente;
import org.ffernandez.threads.ejemplos.sync.runnable.Panadero;

import java.util.concurrent.*;


public class ExecutorProdutorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());





        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable cliente = new Cliente(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(cliente);


        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continuando con la ejecución del main");



    }
}
