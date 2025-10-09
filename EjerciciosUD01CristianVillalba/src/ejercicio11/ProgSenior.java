package ejercicio11;

public class ProgSenior extends Empleado {

    public ProgSenior(String nombre, double porcExtra, double sueldoHora, double horasTrab) {
        super(nombre, porcExtra, sueldoHora, horasTrab);
    }

    @Override
    public double calcularExtra() {
        return super.calcularExtra();
    }

    @Override
    public double calcularSueldoBase() {
        return super.calcularSueldoBase();
    }

    @Override
    public double calcularSueldoTotal() {
        return super.calcularSueldoTotal();
    }
}
