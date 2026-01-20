package ejerciciohashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int opcion=0;
        double precioAgr;
        String aux, tituloAgr, autorAgr, isbnAgr;

        Set<Libro> contenedorLibros = new HashSet<Libro>();
        Libro l1=new Libro(1, "Cien Años de Soledad", "Gabriel García Márquez", "978-0-307-47472-8", 15.0);
        Libro l2 = new Libro(2, "Pedro Páramo", "Juan Rulfo", "978-84-376-0418-3", 10.0);
        Libro l3 = new Libro(3, "Rayuela", "Julio Cortázar", "978-84-376-0494-7", 12.0);
        Libro l4 = new Libro(4, "La casa de los espíritus", "Isabel Allende", "978-84-9759-220-8", 15.0);
        Libro l5 = new Libro(5, "Ficciones", "Jorge Luis Borges", "978-84-9989-113-9", 20.0);

        GestionLibro gl=new GestionLibro(contenedorLibros);

        contenedorLibros.add(l1);
        contenedorLibros.add(l2);
        contenedorLibros.add(l3);
        contenedorLibros.add(l4);
        contenedorLibros.add(l5);


        do {
            System.out.println("""
                    Elija una opción:
                    
                    0. Para salir.
                    1. Para agregar nuevo libro.
                    2. Para imprimir los libros.
                    3. Para modificar un libro.
                    4. Para eliminar un libro.
                    """);
            aux=sc.nextLine();
            opcion=Integer.parseInt(aux);

            switch (opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    System.out.println("Diga el título del libro");
                    tituloAgr=sc.nextLine();

                    System.out.println("Diga el autor del libro.");
                    autorAgr=sc.nextLine();

                    System.out.println("Introduzca el isbn.");
                    isbnAgr=sc.nextLine();

                    System.out.println("Introduzca el precio del libro");
                    aux=sc.nextLine();
                    precioAgr=Double.parseDouble(aux);

                    contenedorLibros.add(new Libro(contenedorLibros.size()+1, tituloAgr, autorAgr, isbnAgr, precioAgr));

                    break;

                case 2:

            }
        }while(opcion!=0);
    }
}
