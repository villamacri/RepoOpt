package ejercicio10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int opcion = 0;
        String aux;
        float radio, longitud, altura;

        System.out.println("Bienvenido");

        do {
            System.out.println("""
                    Seleccione una figura
                    
                    0. Para salir
                    1. Circulo
                    2. Cubo
                    3. Cilindro
                    4. Tetraedro
                    """);
            aux=sc.nextLine();
            opcion=Integer.parseInt(aux);

            switch (opcion){

                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    System.out.println("Calculando área de un círculo, introduzca el radio");
                    aux=sc.nextLine();
                    radio=Float.parseFloat(aux);

                    Circulo ci=new Circulo(radio);

                    System.out.printf("\nEl área del círculo es %.2f\n", ci.calcularArea());
                    break;

                case 2:
                    System.out.println("Calculando área y volumen de un cubo, diga la longitud de la arista.");
                    aux=sc.nextLine();
                    longitud=Float.parseFloat(aux);

                    Cubo cu=new Cubo(longitud);

                    System.out.printf("\nEl área del cubo es %.2f y el volumen %.2f\n", cu.calcularArea(), cu.calcularVol());
                    break;

                case 3:
                    System.out.println("Calculando el área y volumen de un cilindro, diga el radio");
                    aux=sc.nextLine();
                    radio=Float.parseFloat(aux);

                    System.out.println("Diga la altura");
                    aux=sc.nextLine();
                    altura=Float.parseFloat(aux);

                    Cilindro cil=new Cilindro(radio, altura);

                    System.out.printf("\nEl área del cilindro es %.2f y el volumen %.2f\n", cil.calcularArea(), cil.calcularVol());
                    break;

                case 4:
                    System.out.println("Calculando el área y el volumen de un tetraedro, diga la longitud de la arista");
                    aux=sc.nextLine();
                    longitud=Float.parseFloat(aux);

                    Tetraedro t=new Tetraedro(longitud);

                    System.out.printf("\nEl área del tetraedro es %.2f y el volumen %.2f\n", t.calcularArea(),t.calcularVol());
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }while (opcion!=0);

        System.out.println("Adiós");

    }
}
