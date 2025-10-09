package ejercicio09;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dado dado = new Dado();
        Scanner sc=new Scanner(System.in);
        int numTiradas, max = 6, min = 1;
        List<Integer> listaTiradas;
        String [] textChange={
                "El número más repetido es: ",
                "Los números más repetidos son: "
        };
        int opcion, opcionSalir = 0, opcionMax=1;

        System.out.println("Bienvenido");

        do {
            System.out.println("¿Cuántas veces quieres lanzar el dado?");
            numTiradas = Integer.parseInt(sc.nextLine());

            listaTiradas = dado.lanzar(numTiradas, min, max);

            System.out.println("The numbers rolled are: " + listaTiradas);

            System.out.println("The highest rolled number is: " + dado.obtenerMasAlto(listaTiradas, min));
            System.out.println("The lowest rolled number is: " + dado.obtenerMasBajo(listaTiradas, max));
            System.out.println((listaTiradas.size() > 1 ? textChange[0] : textChange[1]) + dado.buscarMasRepetido(listaTiradas, min));

            System.out.println("Wich number do you want to check how many times did it appear? ");
            opcion = Integer.parseInt(sc.nextLine());
            System.out.println("The number: " + opcion + " appear " + dado.contarNumero(listaTiradas, opcion) + " times. ");

            System.out.println("The addition of all the numbers is: " + dado.obtenerSuma(listaTiradas));

            System.out.println("Do you want to repeat? 1-Yes,0-No");
            opcion = Integer.parseInt(sc.nextLine());
            while (opcion > opcionMax || opcion < opcionSalir) {
                System.out.println("Invalid option selected, try again... ");
                opcion = Integer.parseInt(sc.nextLine());
            }

        }while (opcion != opcionSalir);

        System.out.println("Adiós");

    }
}
