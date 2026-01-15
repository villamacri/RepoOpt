package ejercicio02;

public class Conversion {

    public double convertirCelsiusAFarenheit(double celsius){
        double result=0, tope=-273;
        result=(celsius * (9.0/5.0))+32;
        if (celsius<tope){
            throw new TemperaturaLimitException();
        }else{
            return result;
        }
    }
}
