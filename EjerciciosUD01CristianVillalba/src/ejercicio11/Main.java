package ejercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int opcion=0;
        String aux;

        List<Empleado>listado = new ArrayList<>();

        Empleado eJr=new ProgJunior("Dani", 5.0, 14.00, 38.5);
        Empleado eMid=new ProgMid("Jesús", 10, 18, 42.5);
        Empleado eSr=new ProgSenior("Raúl", 15, 22, 50);
        Empleado eLead=new ProgLead("Cristian", 25, 30, 32);

        listado.add(eJr);
        listado.add(eMid);
        listado.add(eSr);
        listado.add(eLead);

        System.out.println("Bienvenido");

        do {
            System.out.println("""
                Seleccione una opción:
                
                0. Para salir.
                1. Para mostrar empleados.
                2. Para calcular el sueldo de los empleados.
                """);
            aux=sc.nextLine();
            opcion=Integer.parseInt(aux);

            switch (opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    for (int i = 0; i < listado.size(); i++) {
                        System.out.println(listado.get(i));
                    }
                    break;

                case 2:
                    for (int i = 0; i < listado.size(); i++) {
                        System.out.printf("\nEl sueldo base de %s es: %.2f\n\tsueldo extra: %.2f\n\tSueldo total: %.2f\n",
                                listado.get(i).getNombre(), listado.get(i).calcularSueldoBase(), listado.get(i).calcularExtra(), listado.get(i).calcularSueldoTotal());
                    }
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }while (opcion!=0);
        System.out.println("Adiós");
    }
}
