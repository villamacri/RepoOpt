package ejemplocopiarfichero;

import java.io.*;

public class Principal {
    public static void main(String[] args) {
        try{
            FileReader flE= new FileReader("Origen.txt");
            BufferedReader fE= new BufferedReader(flE);

            FileWriter flS=new FileWriter("Destino.txt");
            BufferedWriter fS=new BufferedWriter(flS);
            String texto="";
            while (texto != null){
                texto= fE.readLine();
                if(texto != null){
                    fS.write(texto);
                    fS.newLine();
                }
            }
            System.out.println("Copiado Origen en destino");
            fS.close(); //El cierre no va aquí, esto es parte del ejemplo
        }catch (IOException e){
            System.out.println("Error en lectura"+
                    "o escritura de ficheros");
        }
    }
}
