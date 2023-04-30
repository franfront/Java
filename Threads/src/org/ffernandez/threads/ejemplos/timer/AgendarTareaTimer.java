package org.ffernandez.threads.ejemplos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AgendarTareaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en " + new Date() + " por el hilo: " + Thread.currentThread().getName());
                System.out.println("Finaliza el timepo");
                timer.cancel();
            }
        }, 5000);


        System.out.println("Agendamos una tarea para dentro de 5 segundos");
    }
}
