package ejercicio05;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Operaciones {

    private final HashSet<Integer>listaNumeros;

    public Operaciones(HashSet<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    public int generarNumero() throws NumeroRepetidoException{
        Random rnd=new Random();

        int max=100, min=1, num=rnd.nextInt(max-min+1)+min;

        if(!listaNumeros.add(num)){
            throw new NumeroRepetidoException("El número " + num + " ya ha salido");
        }
        return num;
    }
}
