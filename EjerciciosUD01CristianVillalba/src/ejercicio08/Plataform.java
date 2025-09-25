package ejercicio08;

public class Plataform {

    private String paquete;
    private float precio;
    private boolean anuncios;

    public Plataform(String paquete, float precio, boolean anuncios) {
        this.paquete = paquete;
        this.precio = precio;
        this.anuncios = anuncios;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isAnuncios() {
        return anuncios;
    }

    public void setAnuncios(boolean anuncios) {
        this.anuncios = anuncios;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Plataform{" +
                "paquete='" + paquete + '\'' +
                ", precio=" + precio +
                ", anuncios=" + anuncios +
                '}';
    }
}