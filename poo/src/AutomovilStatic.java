public class AutomovilStatic {
    public static void main(String[] args) {

        Automovil subaru= new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor(Color.AZUL);
        subaru.setTipo(TipoAuto.HATCHBACK);



        Automovil mazda = new Automovil("Mazda", "BT-58", Color.ROJO, 3.0 );
        mazda.setTipo(TipoAuto.PICKUP);

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, 3.5, 50);
        nissan.setTipo(TipoAuto.PICKUP);

        Automovil.setColorPatente(Color.AZUL);



        System.out.println(subaru.verDetalles()) ;
        System.out.println(mazda.verDetalles())  ;
        System.out.println(nissan.verDetalles());

        System.out.println("Color de patente: " + Automovil.getColorPatente());



    }
}
