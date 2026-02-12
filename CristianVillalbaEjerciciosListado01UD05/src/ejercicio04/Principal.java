package ejercicio04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) throws IOException {

        Scanner sc =new Scanner(System.in);

        String palabra;
        FileWriter flS = new FileWriter("Palíndromos.txt");
        BufferedWriter bw = new BufferedWriter(flS);
        try{
            System.out.println("Diga una palabra: ");
            palabra=sc.nextLine();

            String valid = new StringBuilder(palabra).reverse().toString();
            if(palabra.equalsIgnoreCase(valid)){
                bw.write(palabra);
            }else{
                System.out.println("No es palíndromo");
            }
            bw.close();
        }catch (IOException e){
            System.err.println("Error al introducir los datos");
        }
    }
}
