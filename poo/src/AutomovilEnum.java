public class AutomovilEnum {
    public static void main(String[] args) {

        Automovil subaru= new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor(Color.AZUL);
        subaru.setTipo(TipoAuto.HATCHBACK);



        Automovil mazda = new Automovil("Mazda", "BT-58", Color.ROJO, 3.0 );
        mazda.setTipo(TipoAuto.PICKUP);

        TipoAuto tipo = subaru.getTipo();
        System.out.println("Tipo subaru: " + tipo.getNombre());
        System.out.println("Descripcion: " + tipo.getDescripcion());

        tipo = mazda.getTipo();

        switch (tipo) {
            case CONVERTIBLE -> System.out.println("Es un convertible");
            case COUPE -> System.out.println("Es una coupe");
            case FURGON -> System.out.println("Es un furgon");
            case HATCHBACK -> System.out.println("Es un auto compacto");
            case PICKUP -> System.out.println("Es una camioneta");
            case SEDAN -> System.out.println("Auto mediano");
            case STATION_WAGON -> System.out.println("El auto mas grande");
        }

        TipoAuto[] tipos = TipoAuto.values();

        for (TipoAuto ta: tipos
             ) {
            System.out.println(ta + "=> " + ta.getNombre() + ", " + ta.getDescripcion());
        }


    }
}
