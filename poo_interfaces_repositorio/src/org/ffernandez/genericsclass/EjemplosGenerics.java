package org.ffernandez.genericsclass;

public class EjemplosGenerics {
    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(8);

        transporteCaballos.agregarObjeto(new Animal("Pepito", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Jose", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Juan", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Apolo", "Caballo"));
        transporteCaballos.agregarObjeto(new Animal("Zeus", "Caballo"));

        for (Animal a : transporteCaballos) {

            System.out.println(a.getNombre() + " " + a.getEspecie());
        }

        Camion<Maquinaria> transporteMaquinaria = new Camion<>(6);
        transporteMaquinaria.agregarObjeto(new Maquinaria("Cargadora"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Excavadora"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Grúa"));
        transporteMaquinaria.agregarObjeto(new Maquinaria("Desmalezadora"));

        for (Maquinaria m : transporteMaquinaria) {

            System.out.println(m.getTipo());
        }



        Camion<Automovil> transAuto = new Camion<>(4);
        transAuto.agregarObjeto(new Automovil("Ford"));
        transAuto.agregarObjeto(new Automovil("Chevrolet"));
        transAuto.agregarObjeto(new Automovil("Fiat"));
        transAuto.agregarObjeto(new Automovil("Renault"));

        for (Automovil a: transAuto) {

            System.out.println(a.getMarca());
        }



    }


}
