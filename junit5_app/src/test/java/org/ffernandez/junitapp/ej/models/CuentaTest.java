package org.ffernandez.junitapp.ej.models;


import org.ffernandez.junitapp.ej.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    @Test // anotación para indicar que es un método de test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
//        cuenta.setPersona("John Doe");
        String esperado = "John Doe";
        String real = cuenta.getPersona();
        assertNotNull(real);
        assertEquals(esperado, real); // un método estático de la clase Assertions
        assertTrue(real.equals("John Doe"));
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // si el saldo es menor a 0 devuelve -1 y si es mayor a 0 devuelve 1 y se compara con 0
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("Franco", new BigDecimal("8900.9998"));
        Cuenta cuenta2 = new Cuenta("Franco", new BigDecimal("8900.9998"));
//        assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Franco", new BigDecimal("1000.12555"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12555", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Franco", new BigDecimal("1000.12555"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12555", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficiente() {
        Cuenta cuenta = new Cuenta("Franco", new BigDecimal("1000.12555"));
        Exception e = assertThrows(DineroInsuficienteException.class, () ->{
           cuenta.debito(new BigDecimal(1500));
        });
        String actual = e.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTranferir() {
        Cuenta c1 = new Cuenta("Franco", new BigDecimal("2500"));
        Cuenta c2 = new Cuenta("Deni", new BigDecimal("4000.5555"));
        Banco banco = new Banco();
        banco.setNombre("Banco de supervillanos");
        banco.transferir(c2, c1, new BigDecimal(500));
        assertEquals("3500.5555", c2.getSaldo().toPlainString());
        assertEquals("3000", c1.getSaldo().toPlainString());
    }

    @Test
    void testBancoCuentas() {
        Cuenta c1 = new Cuenta("Franco", new BigDecimal("2500"));
        Cuenta c2 = new Cuenta("Deni", new BigDecimal("4000.5555"));
        Banco banco = new Banco();
        banco.addCuenta(c1);
        banco.addCuenta(c2);
        banco.setNombre("Banco de supervillanos");
        banco.transferir(c2, c1, new BigDecimal(500));
        assertEquals("3500.5555", c2.getSaldo().toPlainString());
        assertEquals("3000", c1.getSaldo().toPlainString());

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco de supervillanos", c1.getBanco().getNombre());
//        assertEquals("Deni", banco.getCuentas().stream()
//                .filter(c -> c.getPersona().equals("Deni"))
//                .findFirst()
//                .get()
//                .getPersona());

        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Deni"))); // si hay alguna cuenta que cumpla con la condición
    }

}