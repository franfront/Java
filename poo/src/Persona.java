public class Persona {
    private String nombre;
    private String Apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + Apellido ;
    }


}
