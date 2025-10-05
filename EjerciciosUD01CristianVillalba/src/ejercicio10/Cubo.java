package ejercicio10;

public class Cubo extends Figura{

    private float longitudAris;

    public Cubo(float longitudAris) {
        this.longitudAris = longitudAris;
    }

    public float getLongitudAris() {
        return longitudAris;
    }

    public void setLongitudAris(float longitudAris) {
        this.longitudAris = longitudAris;
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "longitudAris=" + longitudAris +
                '}';
    }

    @Override
    public float calcularArea() {
        return (float)(6*Math.pow(longitudAris,2));
    }

    @Override
    public float calcularVol() {
        return (float)(Math.pow(longitudAris,3));
    }
}
