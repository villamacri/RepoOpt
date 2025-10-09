package ejercicio11;

public class ProgJunior extends Empleado{


    public ProgJunior(String nombre, double porcExtra, double sueldoHora, double horasTrab, double horasExtra) {
        super(nombre, porcExtra, sueldoHora, horasTrab, horasExtra);
    }

    @Override
    public double calcularSueldoBase() {
        return super.calcularSueldoBase();
    }

    @Override
    public double calcularExtra() {
        return calcularSueldoBase()+(getSueldoHora()*getHorasExtra()*(getPorcExtra()/100));
    }
}
