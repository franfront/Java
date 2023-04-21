package org.ffernandez.genericsclass;

public class EjemplosGenerics {
    public static <T> void imprmirCamion(Camion<T> camion){
        for (T a : camion) {
            if(a instanceof Animal){
                System.out.println( ((Animal) a).getNombre() + " " + ((Animal) a).getEspecie());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }
    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(8);

        transporteCaballos.agregarObjeto(new Animal("Pepito", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Jose", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Juan", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Apolo", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Zeus", "Caballo"));

        imprmirCamion(transporteCaballos);

        Camion<Maquinaria> transporteMaquinaria = new Camion<>(6);
        transporteMaquinaria.agregarObjeto(new Maquinaria("Cargadora"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Excavadora"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Grúa"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Desmalezadora"));

        imprmirCamion(transporteMaquinaria);



        Camion<Automovil> transAuto = new Camion<>(4);
        transAuto.agregarObjeto(new Automovil("Ford"));
        transAuto.agregarObjeto(new Automovil("Chevrolet"));
        transAuto.agregarObjeto(new Automovil("Fiat"));
        transAuto.agregarObjeto(new Automovil("Renault"));

        imprmirCamion(transAuto);





    }


}
