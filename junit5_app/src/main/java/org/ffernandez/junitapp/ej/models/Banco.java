package org.ffernandez.junitapp.ej.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String nombre;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta){
        this.cuentas.add(cuenta);
        cuenta.setBanco(this); // para que la cuenta sepa a que banco pertenece
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto){
        origen.debito(monto);
        destino.credito(monto);
    }
}
