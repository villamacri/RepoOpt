package ejercicio10;

public class Tetraedro extends Figura {

    private float longitudArista;

    public Tetraedro(float longitudArista) {
        this.longitudArista = longitudArista;
    }

    public float getLongitudArista() {
        return longitudArista;
    }

    public void setLongitudArista(float longitudArista) {
        this.longitudArista = longitudArista;
    }

    @Override
    public String toString() {
        return "Tetraedro{" +
                "longitudArista=" + longitudArista +
                '}';
    }

    @Override
    public float calcularArea() {
        return (float)Math.sqrt(3*Math.pow(longitudArista,2));
    }

    @Override
    public float calcularVol() {
        return (float)(Math.pow(longitudArista,3)/(6*Math.sqrt(2)));
    }
}
