package ejercicio11;

public class Empleado {

    private String nombre;
    private double porcExtra;
    private double sueldoHora;
    private double horasTrab;

    public Empleado(String nombre, double porcExtra, double sueldoHora, double horasTrab) {
        this.nombre = nombre;
        this.porcExtra = porcExtra;
        this.sueldoHora = sueldoHora;
        this.horasTrab = horasTrab;

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

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", porcExtra=" + porcExtra +
                ", sueldoHora=" + sueldoHora +
                ", horasTrab=" + horasTrab +
                '}';
    }

    public double calcularSueldoBase(){
        return sueldoHora*horasTrab;
    };

    public double calcularExtra(){
        if(horasTrab>40){
            return (horasTrab-40)*(sueldoHora+(sueldoHora*(porcExtra/100)));
        }else{
            return 0;
        }

    };

    public double calcularSueldoTotal(){
          return calcularSueldoBase()+calcularExtra();
    };
}
