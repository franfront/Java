package org.ffernandez.interfaces;

import org.ffernandez.interfaces.modelo.Cliente;
import org.ffernandez.interfaces.repositorio.*;
import org.ffernandez.interfaces.repositorio.excepciones.AccesoDatoException;
import org.ffernandez.interfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.ffernandez.interfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.ffernandez.interfaces.repositorio.excepciones.RegistroDuplicadoExcepcion;
import org.ffernandez.interfaces.repositorio.list.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try{

        FullRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.guardar(new Cliente("Franco", "Fernandez"));
        repo.guardar(new Cliente("Denise", "Monges"));

        repo.guardar(new Cliente("Mario", "Sanchez"));

        Cliente luis = new Cliente("Luis", "Perez");

        repo.guardar(luis);
        repo.guardar(luis);



        List<Cliente> clientes = repo.listar();

        clientes.forEach(System.out::println);

        System.out.println("==== Paginable ====");
        List<Cliente> paginable =  repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.println("==== Ordenable ====");
        List<Cliente> ordenable =  repo.listar("nombre", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("==== Editar ====");
        Cliente dActualizado = new Cliente("Denise", "Fernandez");
        dActualizado.setId(2);
        repo.editar(dActualizado);
        System.out.println(repo.porId(2));

        System.out.println("==== Eliminar ====");
        repo.eliminar(4);
        repo.listar().forEach(System.out::println);
        System.out.println("Total: " + repo.total());

        }catch (RegistroDuplicadoExcepcion e){
            System.out.println("Registro duplicado: " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e){
            System.out.println("Error de lectura: " + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e){
            System.out.println("Error de escritura: " + e.getMessage());
            e.printStackTrace();
        }
        catch (AccesoDatoException e){
            System.out.println("Error de acceso a datos: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
