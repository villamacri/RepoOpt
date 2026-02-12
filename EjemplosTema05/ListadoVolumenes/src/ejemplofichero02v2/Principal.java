package ejemplofichero02v2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nombre;

        FileWriter flS = new FileWriter("Agenda.txt");
        BufferedWriter fS = new BufferedWriter(flS);

        try {

            do {
                System.out.println("Introduce un nombre: ");
                nombre = sc.nextLine();
                if (nombre.length() > 0) {
                    System.out.println("Teléfono:");
                    String telefono = sc.nextLine();
                    fS.write(nombre + "," + telefono);
                    fS.newLine();
                }
            } while (nombre.length() > 0);
        } catch (IOException e) {
            System.err.println("Que temprano es");
        } finally {
            fS.close();
            System.out.println("Adiós");
        }

    }
}
