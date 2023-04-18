public enum Color {
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    BLANCO("Blanco"),
    GRIS("Gris oscuro");

    private final String color;

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }

    Color(String color) {
        this.color = color;
    }
}
