package ejercicio11;

public class ProgLead extends Empleado{

    public ProgLead(String nombre, double porcExtra, double sueldoHora, double horasTrab) {
        super(nombre, porcExtra, sueldoHora, horasTrab);
    }

    @Override
    public double calcularSueldoBase() {
        return super.calcularSueldoBase();
    }

    @Override
    public double calcularExtra() {
        return super.calcularExtra();
    }
}
