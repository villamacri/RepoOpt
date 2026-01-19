package ejercicio04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc= new Scanner (System.in);

        double valLeido1=0, valLeido2=0, result=0;
        String aux;
        boolean valid=false;

        Operaciones o=new Operaciones();

        System.out.println("Bienvenido a mi programa de suma.");

        while (!valid){
            try{
                System.out.println("Diga un número: ");
                aux=sc.nextLine();
                valLeido1=Double.parseDouble(aux);

                System.out.println("Diga cuanto le quiere sumar: ");
                aux=sc.nextLine();
                valLeido2=Double.parseDouble(aux);

                result=o.sumar(valLeido1, valLeido2);

                valid=true;

            }catch (SumaLimitException e){
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                System.err.println("Error al introducir los valores");
            }catch(Exception e){
                System.err.println("Error inesperado");
            }
        }

        System.out.printf("El resultado es %.2f", result);

    }
}
