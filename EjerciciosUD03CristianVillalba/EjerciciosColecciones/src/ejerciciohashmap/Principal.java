package ejerciciohashmap;

import java.util.HashMap;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {

        double desc=15.0;

        Map<String, Fruta>tienda=new HashMap<>();
        GestionFruta gf = new GestionFruta(tienda);

        Fruta f1 = new Fruta("Manzana", 1.50);
        Fruta f2 = new Fruta("Aguacate", 4.50);
        Fruta f3 = new Fruta("Mango", 3.80);

        gf.agregarProducto("Manzana", f1);
        gf.agregarProducto("Aguacate", f2);
        gf.agregarProducto("Mango", f3);

        gf.consultarPrecio("Manzana");
        gf.consultarPrecio("Pera"); // No existe

        gf.actualizarPrecio("Manzana", 1.80);

        gf.aplicarRebajas(desc);

        gf.mostrarMap();

        gf.eliminarProducto("Mango");

        gf.consultarPrecio("Mango");

        gf.mostrarMap();
    }
}
