package ejercicio10;

public class Circulo extends Figura{

    private float radio;

    public Circulo(float radio) {
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }

    @Override
    public float calcularArea() {
        return (float)(Math.PI*Math.pow(radio,2));
    }

    @Override
    public float calcularVol() {
        return 0;
    }
}
