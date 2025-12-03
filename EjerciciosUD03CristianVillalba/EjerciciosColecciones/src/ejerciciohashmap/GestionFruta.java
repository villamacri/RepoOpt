package ejerciciohashmap;

import java.util.HashMap;
import java.util.Map;

public class GestionFruta {

    private Map<String, Fruta>inventario;

    public GestionFruta(Map<String, Fruta> inventario) {
        this.inventario = inventario;
    }

    public void mostrarMap(){
        for(Map.Entry<String, Fruta> entrada: inventario.entrySet()) {
            System.out.println(entrada);
        }
    }

    public void agregarProducto(String nombre, Fruta f){
        inventario.put(nombre, f);
    }

    public void consultarPrecio(String nombre){
        if(inventario.containsKey(nombre)){
            System.out.println(inventario.get(nombre));
        }else{
            System.out.println("Error, "+nombre+" no existe en el inventario");
        }
    }

    public void actualizarPrecio(String nombre, double precioNuevo){
        if(inventario.containsKey(nombre)){
            inventario.put(nombre, new Fruta(nombre, precioNuevo));
        }else{
            System.out.println("Error, "+nombre+" no existe");
        }
    }

    public void eliminarProducto(String nombre){
        inventario.remove(nombre);
    }

    public void aplicarRebajas(double desc){
        double precioRebajado;
        for (Map.Entry<String, Fruta> entrada : inventario.entrySet()){
            if(entrada.getValue().getPrecio() > 3.0){
                precioRebajado=entrada.getValue().getPrecio()*(desc/100);
                inventario.put(entrada.getKey(), new Fruta(entrada.getKey(), precioRebajado));
            }
        }
    }
}
