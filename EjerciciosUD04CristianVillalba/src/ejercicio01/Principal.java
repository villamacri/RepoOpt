package ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int num1, num2, result, opcion=0;
        String aux;

        do {
            System.out.println("""
                    Bienvenido, elija que operación va a realizar.
                    
                    0. Salir.
                    1. Sumar
                    2. Multiplicar
                    3. Dividir
                    4. Raiz Cuadrada
                    """);
            aux=sc.nextLine();
            opcion=Integer.parseInt(aux);

            switch(opcion){

                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    try{
                        System.out.println("Diga un número:");
                        aux=sc.nextLine();
                        num1=Integer.parseInt(aux);

                        System.out.println("Diga cuanto le quiere sumar:");
                        aux=sc.nextLine();
                        num2=Integer.parseInt(aux);

                        result=num1+num2;
                        System.out.println("El resultado es " + result);

                    }catch (InputMismatchException | NumberFormatException e){
                        System.err.println("Error al introducir los números");
                    }
                    break;

                case 2:
                    try{
                        System.out.println("Diga un número:");
                        aux=sc.nextLine();
                        num1=Integer.parseInt(aux);

                        System.out.println("Diga por cuanto lo quiere multiplicar:");
                        aux=sc.nextLine();
                        num2=Integer.parseInt(aux);

                        result=num1*num2;
                        System.out.println("El resultado es " + result);

                    }catch (InputMismatchException | NumberFormatException e){
                        System.err.println("Error al introducir los números");
                    }
                    break;

                case 3:
                    try{
                        System.out.println("Diga el numerador:");
                        aux=sc.nextLine();
                        num1=Integer.parseInt(aux);

                        System.out.println("Diga el denominador:");
                        aux=sc.nextLine();
                        num2=Integer.parseInt(aux);

                        result=num1/num2;
                        System.out.println("El resultado es " + result);

                    }catch (InputMismatchException | NumberFormatException e){
                        System.err.println("Error al introducir los números");
                    }catch (ArithmeticException e){
                        System.err.println("Error, está dividiendo por cero");
                    }
                    break;

                case 4:

            }
        }while (opcion!=0);
    }
}
