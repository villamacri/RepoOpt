package ejercicio10;

public class Cilindro extends Figura{

    private float radio;
    private float altura;

    public Cilindro(float radio, float altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + radio +
                ", altura=" + altura +
                '}';
    }

    @Override
    public float calcularArea() {
        return (float)(2*Math.PI*radio*(radio+altura));
    }

    @Override
    public float calcularVol() {
        return (float)(Math.PI*Math.pow(radio,2)*altura);
    }
}
