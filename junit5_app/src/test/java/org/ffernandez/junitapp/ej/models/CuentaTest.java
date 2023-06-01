package org.ffernandez.junitapp.ej.models;


import org.ffernandez.junitapp.ej.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // para que se cree una instancia de la clase de test
class CuentaTest {
    Cuenta cuenta;
    @BeforeEach // se ejecuta antes de cada método de test
    void initMetodoTest(){
        this.cuenta = new Cuenta("John Doe", new BigDecimal("1000.12555"));

        System.out.println("iniciando el metodo");

    }

    @AfterEach // se ejecuta después de cada método de test
    void tearDown(){
        System.out.println("finalizando el metodo");
    }

    @BeforeAll // se ejecuta antes de todos los métodos de test
    static void beforeAll() {
        System.out.println("iniciando el test");
    }

    @AfterAll // se ejecuta después de todos los métodos de test
    static  void afterAll() {
        System.out.println("finalizando el test");
    }

    @Test // anotación para indicar que es un método de test
    @DisplayName("Probando nombre de la cuenta") // indica el nombre del test
    void testNombreCuenta() {
//        cuenta.setPersona("John Doe");
        String esperado = "John Doe";
        String real = cuenta.getPersona();
        assertNotNull(real, ()->"La cuenta no puede ser nula"); // se crea un Supplier para que no se ejecute el método si no es necesario
        assertEquals(esperado, real,()-> "El nombre de la cuenta no es el esperado: se esperaba " + esperado
                + " y se recibio " + real ); // un método estático de la clase Assertions
        assertTrue(real.equals("John Doe"),()-> "El nombre esperado debe ser igual al real");
    }

    @Test
    @DisplayName("Probando el saldo de la cuenta")
    void testSaldoCuenta() {
         cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // si el saldo es menor a 0 devuelve -1 y si es mayor a 0 devuelve 1 y se compara con 0
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Probando referencia cuenta")
    void testReferenciaCuenta() {
        cuenta = new Cuenta("Franco", new BigDecimal("8900.9998"));
        Cuenta cuenta2 = new Cuenta("Franco", new BigDecimal("8900.9998"));
//        assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);
    }

    @Test
    @DisplayName("Probando debito cuenta")
    void testDebitoCuenta() {
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12555", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Probando credito cuenta")
    void testCreditoCuenta() {
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12555", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Probando saldo insuficiente")
    void testDineroInsuficiente() {
        Exception e = assertThrows(DineroInsuficienteException.class, () ->{
           cuenta.debito(new BigDecimal(1500));
        });
        String actual = e.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    @DisplayName("Probando transferencia")
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
//    @Disabled // para que no se ejecute el test
    @DisplayName("Probando referencia de banco")
    void testBancoCuentas() {
//        fail(); // para que falle el test
        Cuenta c1 = new Cuenta("Franco", new BigDecimal("2500"));
        Cuenta c2 = new Cuenta("Deni", new BigDecimal("4000.5555"));
        Banco banco = new Banco();
        banco.addCuenta(c1);
        banco.addCuenta(c2);
        banco.setNombre("Banco de supervillanos");
        banco.transferir(c2, c1, new BigDecimal(500));
        assertAll(
                () -> assertEquals("3500.5555", c2.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta1 no es el esperado"),
                () -> assertEquals("3000", c1.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta2 no es el esperado"),
                () -> assertEquals(2, banco.getCuentas().size(), () -> "El banco no tiene las cuentas esperadas"),
                () -> assertEquals("Banco de supervillanos", c1.getBanco().getNombre()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Deni")))
        );






//        assertEquals("3600.5555", c2.getSaldo().toPlainString());
//        assertEquals("3000", c1.getSaldo().toPlainString());
//
//        assertEquals(2, banco.getCuentas().size());
//        assertEquals("Banco de supervillanos.", c1.getBanco().getNombre());
//
//        assertTrue(banco.getCuentas().stream()
//                .anyMatch(c -> c.getPersona().equals("Deni"))); // si hay alguna cuenta que cumpla con la condición
//

//        assertEquals("Deni", banco.getCuentas().stream()
//                .filter(c -> c.getPersona().equals("Deni"))
//                .findFirst()
//                .get()
//                .getPersona());
    }

    @Test
    @EnabledOnOs(OS.WINDOWS) // para que se ejecute solo en windows
    void soloWindows() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC}) // para que se ejecute solo en linux o mac
    void soloLinuxMac() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS) // para que no se ejecuten en windows
    void testNoWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8) // para que se ejecute solo en java 8
    void soloJdk8() {

    }
}