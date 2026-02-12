package ejercicio05;

public class Alimentacion extends Producto{

    private int diasParaCaducar;
    private boolean refrigerado;

    public Alimentacion(double precioUnitario, String nombre, int codProd, int diasParaCaducar, boolean refrigerado) {
        super(precioUnitario, nombre, codProd);
        this.diasParaCaducar = diasParaCaducar;
        this.refrigerado = refrigerado;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    @Override
    public String toString() {
        return "Alimentacion [diasParaCaducar=" + diasParaCaducar + ", refrigerado=" + refrigerado + "]";
    }

    public void mostrarCad() {
        if(diasParaCaducar<2) {
            System.out.println("  (Aviso, el producto "+super.getNombre()+" esta cerca de caducar, descuento aplicado.)");
        }
    }

    public double calcularPrecioFinal(double iva, double descuento) {
        double precioFinal= super.calcularPrecioFinal(iva, descuento);
        if(diasParaCaducar<2) {
            precioFinal=precioFinal-(precioFinal*descuento/100);
        }
        return precioFinal;
    }
}
