package ejercicio2TipoExamen;

public class Main {
    public static void main(String[] args) {

        double desc=15, ganancia=20, suplEspada=50, dinPago=5000;

        Producto m1=new Movil(150, 3, "Movil Smart", 1, true, "Xiaomi", "Redmi 9");
        Producto m2=new Movil(50, 6, "Movil llama cuelga", 2, false, "Motorola", "Vintage");
        Producto m3=new Movil(1400, 4, "Movil Smart", 3, false, "Apple", "Iphone 15 PRO");

        Producto e1=new Espada(100, 5, "Dardo", 4, true, "A una mano");
        Producto e2=new Espada(300, 3, "Quebrantasoles", 5, false, "Mandoble");
        Producto e3=new Espada(750, 2, "Espada láser Darth Maul", 6, true, "Doble");

        Producto [] lista= {m1, m2, m3, e1, e2, e3};

        Ventas v=new Ventas(lista);

        System.out.println(v.contarProdPorVender());
        System.out.printf("%.2f€\n",v.calcularVentas(desc, ganancia, suplEspada));
        System.out.printf("%.2f€\n",v.calcularCambio(v.calcularVentas(desc, ganancia, suplEspada), dinPago));

        v.mostrarProd();
    }
}
