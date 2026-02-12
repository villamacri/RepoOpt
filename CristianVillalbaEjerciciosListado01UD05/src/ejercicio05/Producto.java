package ejercicio05;

public class Producto {

    private double precioUnitario;
    private String nombre;
    private int codProd;

    public Producto(double precioUnitario, String nombre, int codProd) {
        super();
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.codProd = codProd;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    @Override
    public String toString() {
        return "Producto [precioUnitario=" + precioUnitario + ", nombre=" + nombre + ", codProd=" + codProd + "]";
    }

    public double calcularPrecioFinal(double iva, double descuento) {
        return precioUnitario+(precioUnitario*iva/100);
    }

}
