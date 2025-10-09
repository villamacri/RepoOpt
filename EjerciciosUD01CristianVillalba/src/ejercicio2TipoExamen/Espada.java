package ejercicio2TipoExamen;

public class Espada extends Producto{

    private String tipoEspada;

    public Espada(double precioBase, int cantidad, String nombre, int codProd, boolean vendido, String tipoEspada) {
        super(precioBase, cantidad, nombre, codProd, vendido);
        this.tipoEspada = tipoEspada;
    }

    public String getTipoEspada() {
        return tipoEspada;
    }

    public void setTipoEspada(String tipoEspada) {
        this.tipoEspada = tipoEspada;
    }

    @Override
    public String toString() {
        return "Espada{" +
                "tipoEspada='" + tipoEspada + '\'' +
                '}';
    }

    @Override
    public double calcularPVP(double desc, double ganancia, double suplEspadaDoble) {
        // TODO Auto-generated method stub
        double cien=100, precioFinal=(super.getPrecioBase()+(super.getPrecioBase()*ganancia/cien))*super.getCantidad();
        if(tipoEspada.equalsIgnoreCase("Doble")) {
            precioFinal+=suplEspadaDoble;
        }
        return precioFinal;
    }
}
