package org.ffernandez.interfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja implements Imprimible{

    private Persona persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculum(Persona persona, String carrera, String texto) {
        super(texto);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public void addExperiencia(String exp){
        this.experiencias.add(exp);
    }


    @Override
    public String imprimir() {

        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(persona).append("\n")
                .append("Resumen: ").append(this.texto)
                .append("\n").append("Carrera: ")
                .append(carrera).append("\n")
                .append("Experiencias: \n");

        for (String exp : this.experiencias) {
            sb.append("- ").append(exp).append("\n");
        }

        return sb.toString();
    }
}
