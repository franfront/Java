package org.ffernandez.threads.ejemplos.executor;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

       ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        AtomicInteger contador = new AtomicInteger(5);
        //CountDownLatch lock = new CountDownLatch(5); // cuenta atras
        Future<?> future = executor.scheduleAtFixedRate(() ->{
            System.out.println("Alguna tarea en el executor");
            try {
                TimeUnit.SECONDS.sleep(1);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }, 1,2 ,TimeUnit.SECONDS);

        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);

        while(contador.get() >= 0){

            if(contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
            System.out.println("Esperando a que contador llegue a 0");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Alguna otra tarea en el main");
        executor.shutdown();
    }
}
