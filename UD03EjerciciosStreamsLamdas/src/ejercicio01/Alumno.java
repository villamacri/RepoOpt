package ejercicio01;

public class Alumno {

    private String nombre, apellidos, nombreCuro;
    private double notaMedia;
    private int edad;

    public Alumno(String nombre, String apellidos, String nombreCuro, double notaMedia, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreCuro = nombreCuro;
        this.notaMedia = notaMedia;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCuro() {
        return nombreCuro;
    }

    public void setNombreCuro(String nombreCuro) {
        this.nombreCuro = nombreCuro;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ejercicio01.Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreCuro='" + nombreCuro + '\'' +
                ", notaMedia=" + notaMedia +
                ", edad=" + edad +
                '}';
    }
}
