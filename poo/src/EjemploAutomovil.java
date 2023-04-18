public class EjemploAutomovil {
    public static void main(String[] args) {

        Automovil subaru= new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor(Color.BLANCO);


        Automovil mazda = new Automovil("Mazda", "BT-58", Color.GRIS, 3.0 );


        Automovil nissan = new Automovil("Nissan", "Navara", Color.AZUL, 3.5, 50);

        


        System.out.println(subaru.verDetalles()) ;
        System.out.println(mazda.verDetalles())  ;
        System.out.println(nissan.verDetalles());

        System.out.println(subaru.acelerarFrenar(3000));
        System.out.println(mazda.acelerarFrenar(2000));

        System.out.println("Kilometros por litro  " + subaru.consumo(300, 0.75f));

        System.out.println("Kilometros por litro  " + nissan.consumo(300, 60));




    }
}
