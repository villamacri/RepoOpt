package ejercicio05;

import java.lang.reflect.Array;
import java.util.*;

public class Operaciones {

    private final Set<Integer>listaNumeros;
    private List<Cuenta> listadoCuentas;

    public Operaciones(Set<Integer> listaNumeros, List<Cuenta> listadoCuentas) {
        this.listaNumeros = listaNumeros;
        this.listadoCuentas=listadoCuentas;
    }

    public int generarNumero() throws NumeroRepetidoException{
        Random rnd=new Random();

        int max=100, min=1, num=rnd.nextInt(max-min+1)+min;

        if(!listaNumeros.add(num)){
            throw new NumeroRepetidoException("El número " + num + " ya ha salido");
        }
        return num;
    }

    public void setearId(int idBuscado, int idNuevo) throws AsignacionIdException{
        if(listadoCuentas.contains(listadoCuentas.get(idNuevo)))
            throw new AsignacionIdException("El id ya está asignado a otra cuenta");

            listadoCuentas.get(idBuscado).setId(idNuevo);
    }

    public void comprobarImpares()throws NumeroImparException{
        for (Integer numero : listaNumeros) {
            if(numero % 2 != 0){
                throw new NumeroImparException("El número"+ numero + "es impar");
            }
        }
    }

    public void comprobarSaldo (double saldo, int id) throws CantidadBizzumException{
        if(saldo > listadoCuentas.get(id).getSaldo()){
            throw new CantidadBizzumException("El saldo pedido es mayor al disponible");
        }
    }



}
