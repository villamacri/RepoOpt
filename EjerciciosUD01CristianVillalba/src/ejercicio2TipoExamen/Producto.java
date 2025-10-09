package ejercicio2TipoExamen;

public abstract class Producto {

    private double precioBase;
    private int cantidad;
    private String nombre;
    private int codProd;
    private boolean vendido;

    public Producto(double precioBase, int cantidad, String nombre, int codProd, boolean vendido) {
        super();
        this.precioBase = precioBase;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.codProd = codProd;
        this.vendido = vendido;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precioBase=" + precioBase +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                ", codProd=" + codProd +
                ", vendido=" + vendido +
                '}';
    }

    public abstract double calcularPVP(double desc, double ganancia, double suplEspadaDoble);
}
