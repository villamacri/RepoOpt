package ejercicio.model;

public class Pedido {

    private String cod;
    private String direccion;
    private double precio;

    public Pedido(String cod, String direccion, double precio) {
        this.cod = cod;
        this.direccion = direccion;
        this.precio = precio;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cod='" + cod + '\'' +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
