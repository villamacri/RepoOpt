package ejercicio05;

public class Electronica extends Producto{

    private double impLujo;
    private boolean lujo;

    public Electronica(double precioUnitario, String nombre, int codProd, double impLujo, boolean lujo) {
        super(precioUnitario, nombre, codProd);
        this.impLujo = impLujo;
        this.lujo = lujo;
    }

    public double getImpElect() {
        return impLujo;
    }

    public void setImpElect(double impElect) {
        this.impLujo = impElect;
    }

    public boolean isLujo() {
        return lujo;
    }

    public void setLujo(boolean lujo) {
        this.lujo = lujo;
    }

    @Override
    public String toString() {
        return "Electronica [impElect=" + impLujo + ", lujo=" + lujo + "]";
    }

    public double calcularPrecioFinal(double iva, double descuento) {
        double precioFinal = super.calcularPrecioFinal(iva, descuento);
        if(lujo) {
            precioFinal=precioFinal+(precioFinal*impLujo/100);
        }
        return precioFinal;
    }
}
