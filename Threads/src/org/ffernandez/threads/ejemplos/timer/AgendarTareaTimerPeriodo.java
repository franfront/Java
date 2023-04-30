package org.ffernandez.threads.ejemplos.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class AgendarTareaTimerPeriodo {
    public static void main(String[] args) {


        Toolkit toolkit = Toolkit.getDefaultToolkit();

        AtomicInteger contador = new AtomicInteger(5);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int i = contador.getAndDecrement();

                if(i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea " + contador +" periodica en " + new Date() + " por el hilo: " + Thread.currentThread().getName());

                } else {
                    System.out.println("Finaliza el timepo");
                    timer.cancel();
                }

                //timer.cancel();
            }
        }, 0, 10000);


        System.out.println("Agendamos una tarea de inmediato que se repite cada 10 segundos");
    }
}
