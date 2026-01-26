package ejercicio;

import ejercicio.errors.FormatoTextoException;
import ejercicio.errors.OperacionNumericaException;
import ejercicio.model.Pedido;
import ejercicio.service.GestionPedidos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion=0;
        double precio=0.0;
        String aux, codigo, direccion;
        boolean valid=false;

        List<Pedido>listadoPedidos = new ArrayList<>();
        GestionPedidos gp= new GestionPedidos();

        System.out.println("Bienvenido");
        do {
            while (!valid) {
                try {
                    System.out.println("""
                            Diga que es lo que desea hacer:
                            0. Para salir.
                            1. Para agregar un pedido.
                            2. Para mostrar los pedidos.
                            """);
                    aux = sc.nextLine();
                    opcion = Integer.parseInt(aux);

                    valid=true;
                } catch (NumberFormatException e) {
                    System.err.println("Error, la opción introducida tiene que ser un número entero");
                } catch (Exception e) {
                    System.err.println("Error inesperado");
                }
            }
            switch (opcion){
                //codigo, direccion, precio
                case 0:
                    System.out.println("Saliendo...");
                    break;

                case 1:
                    try {
                        System.out.println("Diga el codigo del pedido a agregar: ");
                        codigo = sc.nextLine();
                        gp.validarCodigo(codigo);

                        System.out.println("Diga la direccion del pedido: ");
                        direccion = sc.nextLine();
                        gp.validarDireccion(direccion);

                        System.out.println("Diga el precio del pedido: ");
                        aux=sc.nextLine();
                        precio=Double.parseDouble(aux);
                        gp.validarPrecio(precio);

                        listadoPedidos.add(new Pedido(codigo, direccion, precio));

                        System.out.println("Pedido agregado correctamente");

                    }catch(FormatoTextoException e) {
                        System.err.println(e.getMessage());
                    }catch(OperacionNumericaException e){
                        System.err.println(e.getMessage());
                    }catch (NumberFormatException e) {
                        System.err.println("El valor introducido no es válido");
                    }catch (InputMismatchException e) {
                        System.err.println("Error al introducir los datos");
                    }catch (Exception e){
                        System.err.println("Error inesperado");
                    }
                    break;

                case 2:
                    for (Pedido p : listadoPedidos) {
                        System.out.println(p);
                    }
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while (opcion!=0);

        System.out.println("Adiós");
    }
}
