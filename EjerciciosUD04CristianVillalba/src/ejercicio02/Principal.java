package ejercicio02;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        double valorLeido, result=0;
        boolean valid=false;
        String aux;

        Conversion c=new Conversion();

        System.out.println("Bienvenido a la conversión de grados celsius");

        while (!valid) {
            try {
                System.out.println("Diga la temperatura que quiere convertir a Farenheit");
                aux = sc.nextLine();
                valorLeido = Double.parseDouble(aux);

                result = c.convertirCelsiusAFarenheit(valorLeido);

                valid=true;
            } catch (TemperaturaLimitException e) {
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                System.err.println("El valor introducido no es un número");
            }catch (Exception e){
                System.err.println("Error inesperado");
            }
        }

        System.out.println("El resultado de la conversión es: " + result);
    }
}
