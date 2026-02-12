package ejercicio05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Venta {

    private LineaDeVenta [] listado;

    public Venta(LineaDeVenta[] listado) {
        super();
        this.listado = listado;
    }

    public LineaDeVenta[] getListado() {
        return listado;
    }

    public void setListado(LineaDeVenta[] listado) {
        this.listado = listado;
    }

    @Override
    public String toString() {
        return "Venta [listado=" + Arrays.toString(listado) + "]";
    }

    public Producto findByCod(int codProd) {
        Producto p = null;
        int i=0;
        boolean encontrado=false;

        while(i<listado.length && !encontrado) {
            if(listado[i].getP().getCodProd()==codProd) {
                p=listado[i].getP();
                encontrado=true;
            }
            i++;
        }
        return p;
    }

    public void agregarLV(LineaDeVenta lV) {
        boolean encontrado=false;

        //Esto hace que cuando el elemento del array es null entra, guarda la linea de venta
        //en el elemento y cambia el encontrado a true para salir del bucle.
        for (int i = 0; i < listado.length && listado[i]==null && !encontrado; i++) {
            listado[i]=lV;
            encontrado=true;

        }
    }

    public void imprimirListado() {
        for (int i = 0; i < listado.length && listado[i]!=null; i++) {
            System.out.println(listado[i]);
            if(listado[i].getP() instanceof Alimentacion) {
                ((Alimentacion)listado[i].getP()).mostrarCad();
            }
        }
    }

    public double sumaTotal(double iva, double descuento) {
        double suma=0;
        for (int i = 0; i < listado.length && listado[i]!=null; i++) {
            suma+=listado[i].getP().calcularPrecioFinal(iva, descuento)*listado[i].getCantidad();
        }
        return suma;
    }

    public String generarTicket(double iva, double descuento) {
        String nombre;
        double precioU, precioF, suma;
        int cant;
        StringBuilder sb = new StringBuilder();

        sb.append("Producto\tUd\t\tPrecio Unitario\t\tIVA\t\tImporte\n");
        for (int i = 0; i < listado.length && listado[i]!=null; i++) {
            nombre=listado[i].getP().getNombre();
            cant=listado[i].getCantidad();
            precioU=listado[i].getP().calcularPrecioFinal(iva, descuento);
            precioF=listado[i].calcularSubtotal(iva, descuento);

            sb.append(String.format("%s\t\t%d\t\t%.2f€\t\t\t%.2f%%\t\t%.2f€\n",
                    nombre, cant, precioU, iva, precioF));

        }
        suma=sumaTotal(iva, descuento);
        sb.append(String.format("\n\t\t\t\t\t\t\t   Subtotal:    %.2f€\n", suma));
        return sb.toString();
    }

    public double calcularTotalDinDescontado(double iva, double descuento) {
        double res=0;
        for (int i = 0; i < listado.length && listado[i]!=null; i++) {
            res+=(listado[i].getP().calcularPrecioFinal(iva, descuento)-listado[i].getP().getPrecioUnitario())*listado[i].getCantidad();
        }
        return res;
    }

    public void guardarEnUnFichero(String s) throws IOException {
        FileWriter flS = new FileWriter("Tickets.txt");
        BufferedWriter bw= new BufferedWriter(flS);

        bw.write(s);
        bw.newLine();
        bw.close();

    }
}
