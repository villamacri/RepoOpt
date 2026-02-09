package ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        String nombre, posicion, tiempo, carrera;

        FileWriter flS= new FileWriter("America's cup resultados.txt");
        BufferedWriter fS= new BufferedWriter(flS);

        try{

            do{
                System.out.println("Introduce el nombre: ");
                nombre=sc.nextLine();
                if(nombre.length() > 0){
                    System.out.println("posición: ");
                    posicion=sc.nextLine();

                    System.out.println("tiempo: ");
                    tiempo=sc.nextLine();

                    System.out.println("carrera: ");
                    carrera=sc.nextLine();
                }
            }while (nombre.length()>0);
        }catch (IOException e){
            System.out.println("Error al introducir los datos");
        }finally{
            fS.close();
            System.out.println("Adiós");
        }


    }
}
