public enum TipoAuto {
    SEDAN("Sedan", "Auto mediano,", 4),
    STATION_WAGON("Station Wagon", "Auto grande", 4),
    HATCHBACK("Hatchback", "Auto compacto", 4),
    PICKUP("Pickup", "Camioneta", 4),
    COUPE("Coupé", "Auto pequeño", 2),
    CONVERTIBLE("Convertible", "Auto deportivo", 2),
    FURGON("Furgón", "Auto utilitario", 2);

    private final String nombre;
    private final int puertas;
    private final String descripcion;

    TipoAuto(String nombre, String descripcion, int puertas) {
        this.nombre = nombre;
        this.puertas = puertas;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
