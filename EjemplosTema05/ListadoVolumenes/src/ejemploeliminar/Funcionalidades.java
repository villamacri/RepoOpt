package ejemploeliminar;

import java.io.*;

public class Funcionalidades {

    //Solo por ser ejemplo, no se implementa la excepción
    public void borrarLinea(String file, String lineaBorrar) {

        try {
            File inFile =new File(file);
            if(!inFile.isFile()){
                System.out.println("El parámetro no es un archivo");
                return;
            }
            //Creamos un archivo temporal
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            while ((line = br.readLine()) != null){

                if(!line.trim().equals(lineaBorrar)){
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            if(!inFile.delete()){
                System.out.println("No se ha podido borrar el archivo");
                return;
            }
            if(!tempFile.renameTo(inFile))
                System.out.println("No se ha podido renombrar");
        }catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
