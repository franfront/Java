package org.ffernandez.recursividad.ej;

import org.ffernandez.recursividad.ej.models.Componente;

import java.util.stream.Stream;

public class EjRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATX");
        Componente fuente = new Componente("Fuente de poder 650w");
        Componente motherboard = new Componente("Motherboard Asus Prime H510M-E");
        Componente cpu = new Componente("CPU Intel Core I7 10700");
        Componente ram = new Componente("Memoria RAM 32GB DDR4 3200MHz");
        Componente tv = new Componente("Nvidia RTX 3070 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuVentilador = new Componente("Ventilador GPU");
        Componente gpuRam = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente ssd = new Componente("Disco SSD 1TB");
        Componente ventilador = new Componente("Ventilador 120mm");
        Componente disipa = new Componente("Disipador de calor");

        cpu.addComponente(ventilador)
                .addComponente(disipa);

        tv.addComponente(gpu).
                addComponente(gpuRam)
                .addComponente(gpuRam2).
                addComponente(gpuVentilador);

        motherboard.addComponente(cpu)
                .addComponente(ram)
                .addComponente(tv)
                .addComponente(ssd);

        pc.addComponente(fuente)
                .addComponente(motherboard)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        metodoRecurisvoJava8(pc, 0).forEach(c -> System.out.println("-".repeat(c.getNivel()) + c.getNombre()));


    }

    public static Stream<Componente> metodoRecurisvoJava8(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(
                Stream.of(c),
                c.getHijos().stream().flatMap(hijo ->
                        metodoRecurisvoJava8(hijo, nivel+1))
        );

    }

    public static void metodoRecurisvo( Componente c, int nivel){
        System.out.println("-".repeat(nivel) +c.getNombre());
        if(c.hasChildren()){
            for(Componente hijo: c.getHijos()){
                metodoRecurisvo(hijo, nivel+1);
            }
        }
    }

}
