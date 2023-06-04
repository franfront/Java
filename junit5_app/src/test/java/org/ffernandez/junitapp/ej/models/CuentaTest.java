package org.ffernandez.junitapp.ej.models;


import org.ffernandez.junitapp.ej.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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

    @Nested
    @DisplayName("Probando atributos de la cuenta")
    class CuentaTestNombreSaldo{
        @Test // anotación para indicar que es un método de test
        @DisplayName("Nombre") // indica el nombre del test
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
        @DisplayName("Saldo")
        void testSaldoCuenta() {
            cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // si el saldo es menor a 0 devuelve -1 y si es mayor a 0 devuelve 1 y se compara con 0
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("Referencia")
        void testReferenciaCuenta() {
            cuenta = new Cuenta("Franco", new BigDecimal("8900.9998"));
            Cuenta cuenta2 = new Cuenta("Franco", new BigDecimal("8900.9998"));
//        assertNotEquals(cuenta2, cuenta);
            assertEquals(cuenta2, cuenta);
        }


    }

    @Nested
    @DisplayName("Probando operaciones de la cuenta")
    class CuentaOperacionesTest{
        @Test
        @DisplayName("Debito")
        void testDebitoCuenta() {
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12555", cuenta.getSaldo().toPlainString());
        }

        @Test
        @DisplayName("Credito")
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12555", cuenta.getSaldo().toPlainString());
        }

        @Test
        @DisplayName("Transferencia")
        void testTranferir() {
            Cuenta c1 = new Cuenta("Franco", new BigDecimal("2500"));
            Cuenta c2 = new Cuenta("Deni", new BigDecimal("4000.5555"));
            Banco banco = new Banco();
            banco.setNombre("Banco de supervillanos");
            banco.transferir(c2, c1, new BigDecimal(500));
            assertEquals("3500.5555", c2.getSaldo().toPlainString());
            assertEquals("3000", c1.getSaldo().toPlainString());
        }


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

    @Nested // para agrupar test
    class SistemaOperativoTest{

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

    }

    @Nested
    class JavaVersionTest{
        @Test
        @EnabledOnJre(JRE.JAVA_8) // para que se ejecute solo en java 8
        void soloJdk8() {

        }

        @Test
        @EnabledOnJre(JRE.JAVA_17)
        void soloJdk17() {

        }


    }

    @Nested
    class  SistemaPropertiesTest{
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k,v) -> System.out.println(k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "17.*")
        void testJavaVersion() {

        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32")
        void testSolo64() {

        }
        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32")
        void testNo64() {

        }

        @Test
        @EnabledIfSystemProperty(named = "uder.name", matches = "Franco")
        void name() {

        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {

        }


    }


    @Nested
    class VariableAmbienteTest{
        @Test
        void imprimirVariablesAmbtiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k,v) -> System.out.println(k + "=" + v));

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "2")
        void testProcesadores() {

        }

    }




    @Test
    @DisplayName("test Saldo Cuenta Dev")
    void testSaldoCuentaDev() {


        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // si el saldo es menor a 0 devuelve -1 y si es mayor a 0 devuelve 1 y se compara con 0
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("test Saldo Cuenta Dev 2")
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> { // se ejecuta solo si la condición es true
            cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // si el saldo es menor a 0 devuelve -1 y si es mayor a 0 devuelve 1 y se compara con 0
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });

    }

    @RepeatedTest(value=5, name = "{displayName} - Repetición numero {currentRepetition} de {totalRepetitions}") // para repetir el test 5 veces
    @DisplayName("Debito repetido")
    void testDebitoCuentaRepetir( RepetitionInfo info) {
        if (info.getCurrentRepetition() == 2) {
            System.out.println("Estamos en la repetición " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12555", cuenta.getSaldo().toPlainString());
    }


    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}") // para poder pasarle parametros al test
    @ValueSource( strings = {"100", "200", "500", "700", "1000" }) // pasandole los parametros
    @DisplayName("ValueSource Debito con parametros")
    void testDebitoValueSource(String monto) {

        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}") // para poder pasarle parametros al test
    @CsvSource({"1, 100", "2, 200", "3, 500", "4, 700", "5, 1000" }) // pasandole los parametros
    @DisplayName("CsvSource Debito con parametros")
    void testDebitoCsvSource(String index, String monto) {
        System.out.println(index + " -> " + monto);
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}") // para poder pasarle parametros al test
    @CsvFileSource(resources = "/data.csv") // pasandole los parametros
    @DisplayName("CsvFileSource Debito con parametros")
    void testDebitoCsvFileSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}") // para poder pasarle parametros al test
    @MethodSource("montoList") // pasandole los parametros
    @DisplayName("MethodSource Debito con parametros")
    void testDebitoMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    static List<String> montoList() {
        return Arrays.asList("100", "200", "500", "700", "1000");
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}") // para poder pasarle parametros al test
    @CsvSource({"200, 100, John, Franco", "250, 200, Pepe, Pepe", "500, 500, deni, Deni", "750, 700, Pepa, Pepa", "1000, 1000, Luca, Luca"})
    void testDebitoCsvSource2(String saldo, String monto, String esperado, String actual) {
        System.out.println(saldo + " -> " + monto);
        cuenta.setSaldo(new BigDecimal(saldo));
        cuenta.debito(new BigDecimal(monto));
        cuenta.setPersona(actual);
        assertNotNull(cuenta.getSaldo());
        assertNotNull(cuenta.getPersona());
        assertEquals(esperado, actual);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

}