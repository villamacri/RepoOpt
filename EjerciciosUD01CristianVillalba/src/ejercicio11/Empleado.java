package ejercicio11;

public abstract class Empleado {

    private String nombre;
    private double porcExtra;
    private double sueldoHora;
    private double horasTrab;
    private double horasExtra;

    public Empleado(String nombre, double porcExtra, double sueldoHora, double horasTrab, double horasExtra) {
        this.nombre = nombre;
        this.porcExtra = porcExtra;
        this.sueldoHora = sueldoHora;
        this.horasTrab = horasTrab;
        this.horasExtra = horasExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcExtra() {
        return porcExtra;
    }

    public void setPorcExtra(double porcExtra) {
        this.porcExtra = porcExtra;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public double getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(double horasTrab) {
        this.horasTrab = horasTrab;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double calcularSueldoBase(){
        return sueldoHora*horasTrab;
    };

    public abstract double calcularExtra();
}
