package ejercicio11;

public class ProgJunior extends Empleado{


    public ProgJunior(String nombre, double porcExtra, double sueldoHora, double horasTrab) {
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
