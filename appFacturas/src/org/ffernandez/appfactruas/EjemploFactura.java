package org.ffernandez.appfactruas;

import org.ffernandez.appfactruas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Franco");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura");
        String desc = sc.nextLine();

        Factura factura = new Factura(desc, cliente);

        Producto producto;

        for(int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto numero " + producto.getCodigo() + ": ");

            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad: ");




            factura.addItem(new ItemFactura(sc.nextInt(), producto));
            System.out.println();
            sc.nextLine();




        }
        System.out.println(factura.generarDetalle());


    }
}
