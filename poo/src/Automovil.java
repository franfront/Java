public class Automovil {

    private String fabricante;
    private String modelo;
    private Color color;
    private Motor motor;

    private Tanque tanque;

    private Persona conductor;

    private Rueda[] ruedas;


    private TipoAuto tipo;

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public static final int VELOCIDAD_MAXIMA_CIUDAD = 60;

    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris";





    static Color colorPatente = Color.ROJO;



    public Automovil() {
    }

    public Automovil(String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }


    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque) {
        this(fabricante, modelo, color,motor);
        this.tanque = tanque;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public static Color getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }


    public TipoAuto getTipo() {
        return tipo;
    }

    public void setTipo(TipoAuto tipo) {
        this.tipo = tipo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public String verDetalles(){

        return "Fabricante = " + this.fabricante +
                "\nModelo = " + this.modelo +
                "\nTipo = " + this.getTipo().getDescripcion() +
                "\nColor = " + this.color +
                "\nCilindrada = " + this.motor.getCilindrada()+
                "\nColorPatente = " + colorPatente;
    }

    public String acelerar(int rpm){


        return "El auto " + fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar(){
        return  fabricante + " " + modelo + " frenando!";
    }

    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float consumo(int km, float nafta){

        return km/(tanque.getCapacidad() * nafta );
    }

    public float consumo(int km, int nafta){

        return km/(tanque.getCapacidad() *( nafta/130f) );
    }

}

