package listadovolumenes;

import java.io.File;

public class Principal {
    public static void main(String[] args) {

        File canal=new File("C:/Users/villalba.macri24_tri/Desktop/2DAM/OPT/RepoOpt/EjemplosTema05/ejemplo");
        File [] listaFiles = canal.listFiles();
    }
}
