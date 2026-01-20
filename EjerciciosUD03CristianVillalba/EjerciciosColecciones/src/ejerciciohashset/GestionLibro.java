package ejerciciohashset;

import java.util.HashSet;
import java.util.Set;

public class GestionLibro {

    private Set<Libro> contenedor;

    public GestionLibro(Set<Libro> contenedor) {
        this.contenedor = contenedor;
    }

    public Set<Libro> getContenedor() {
        return contenedor;
    }

    public void setContenedor(Set<Libro> contenedor) {
        this.contenedor = contenedor;
    }

    public Libro findByTitulo(String titulo){
        Libro buscado;

        return buscado = contenedor.stream()
                .filter(b -> b.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public void agregarLibro(Libro libro){
        contenedor.add(libro);
    }

    public void imprimirContenedorLibros(){
        for (Libro libro : contenedor) {
            System.out.println(libro);
        }
    }

    public void editarAutorLibro(String titulo, String autorNuevo){

        Libro libroNuevo=new Libro(findByTitulo(titulo).getId(), findByTitulo(titulo).getTitulo(), autorNuevo, findByTitulo(titulo).getIsbn(), findByTitulo(titulo).getPrecio());
        contenedor.remove(findByTitulo(titulo));
        agregarLibro(libroNuevo);

    }

    public void delete(String titulo){
        contenedor.remove(findByTitulo(titulo));
    }

    public double calcularPrecioVenta(String titulo, double iva, double desc, int cant, int tope, double cien){
        if(cant>tope){
            return ((findByTitulo(titulo).getPrecio()+findByTitulo(titulo).getPrecio()*(iva/cien))-findByTitulo(titulo).getPrecio()*(desc/cien)) * cant;
        }else {
            return (findByTitulo(titulo).getPrecio()+findByTitulo(titulo).getPrecio()*(iva/cien))*cant;
        }
    }

    public void comprobarOfertaDelDia(String titulo, String autor){
        if(findByTitulo(titulo).getAutor().equalsIgnoreCase(autor)){
            System.out.println("¡Enhorabuena!, el autor del día es " + autor + ", tienes otra copia de regalo.");
        }
    }

}
