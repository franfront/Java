public class Rueda {
    private String faricante;
    private  int aro;
    private double ancho;

    public Rueda(String faricante, int aro, double ancho) {
        this.faricante = faricante;
        this.aro = aro;
        this.ancho = ancho;
    }

    public String getFaricante() {
        return faricante;
    }

    public int getAro() {
        return aro;
    }

    public double getAncho() {
        return ancho;
    }
}
