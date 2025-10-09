package ejercicio2TipoExamen;

public class Movil extends Producto{

    private String marca;
    private String modelo;

    public Movil(double precioBase, int cantidad, String nombre, int codProd, boolean vendido, String marca,
                 String modelo) {
        super(precioBase, cantidad, nombre, codProd, vendido);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Movil{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    @Override
    public double calcularPVP(double desc, double ganancia, double suplEspadaDoble) {
        // TODO Auto-generated method stub
        double cien=100;
        return (super.getPrecioBase()+(super.getPrecioBase()*ganancia/cien))*super.getCantidad();
    }
}
