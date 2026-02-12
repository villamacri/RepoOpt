package ejercicio05;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc= new Scanner(System.in);

        int opcion=0, tam=10, codLeido;
        double iva=21.0, descuento= 15.0;
        String aux, ticket;

        Producto a1 = new Alimentacion(1.20, "Leche", 1, 5, true);
        Producto a2 = new Alimentacion(2.50, "Donuts", 2, 1, false);
        Producto e1 = new Electronica(400.00, "Tv LG", 3, 20, true);
        Producto e2 = new Electronica(250.00, "Patín", 4, 20, false);

        LineaDeVenta l1 = new LineaDeVenta(a1, 3);
        LineaDeVenta l2 = new LineaDeVenta(a2, 5);
        LineaDeVenta l3 = new LineaDeVenta(e1, 1);
        LineaDeVenta l4 = new LineaDeVenta(e2, 2);

        LineaDeVenta [] listado= new LineaDeVenta[tam];

        listado[0]= l1;
        listado[1]= l2;
        listado[2]= l3;
        listado[3]= l4;

        Venta v=new Venta(listado);

        System.out.println("Bienvenido");

        do {
            System.out.println("""
					0. Para salir.
					1. Para imprimir ticket.
					2. Para listar.
					3. Para buscar un producto.
					4. Imprimir dinero descontado en total.
					5. Para guardar en un fichero.
					""");
            aux=sc.nextLine();
            opcion=Integer.parseInt(aux);
            switch(opcion) {
                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    System.out.println(v.generarTicket(iva, descuento));
                    break;

                case 2:
                    v.imprimirListado();
                    break;

                case 3:
                    System.out.println("Introduzca el código del producto");
                    aux=sc.nextLine();
                    codLeido=Integer.parseInt(aux);

                    System.out.println(v.findByCod(codLeido).getNombre()+": "+v.findByCod(codLeido));
                    break;

                case 4:
                    System.out.printf("El dinero total descontado es de %.2f€\n",v.calcularTotalDinDescontado(iva, descuento));
                    break;

                case 5:
                    try{
                        v.guardarEnUnFichero(v.generarTicket(iva, descuento));
                    }catch (IOException e){
                        System.err.println("Error al guardar el fichero");
                    }
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(opcion!=0);
    }

}
