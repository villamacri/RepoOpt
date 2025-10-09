package ejercicio2TipoExamen;

import java.util.Arrays;

public class Ventas {

    private Producto [] listado;

    public Ventas(Producto[] listado) {
        super();
        this.listado = listado;
    }

    public Producto[] getListado() {
        return listado;
    }

    public void setListado(Producto[] listado) {
        this.listado = listado;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "listado=" + Arrays.toString(listado) +
                '}';
    }

    public int contarProdPorVender() {
        int contador=0;
        for (int i = 0; i < listado.length; i++) {
            if(!listado[i].isVendido()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularVentas(double desc, double ganancia, double suplEspadaDoble) {
        double dinVentas=0;
        for (int i = 0; i < listado.length; i++) {
            if(listado[i].isVendido()) {
                dinVentas+=listado[i].calcularPVP(desc, ganancia, suplEspadaDoble);
            }
        }
        return dinVentas;
    }

    public Producto findByCodProd(int codBuscado) {
        Producto buscado=null;
        boolean encontrado=false;

        for (int i = 0; i < listado.length && listado[i]!=null && !encontrado; i++) {
            if(listado[i].getCodProd()==codBuscado) {
                buscado=listado[i];
                encontrado=true;
            }
        }
        return buscado;
    }


    public double calcularCambio(double APagar, double dinPago) {
        double cambio = 0;
        if(dinPago>=APagar) {
            cambio=dinPago-APagar;
        }
        return cambio;
    }

    public void mostrarProd() {
        for (int i = 0; i < listado.length; i++) {
            if(listado[i] instanceof Espada) {;
                System.out.println(listado[i].toString()+": ¡Cuidadín al sacarla de la bolsa, hace pupa!");
            }else {
                System.out.println(listado[i].toString());
            }

        }
    }

}
