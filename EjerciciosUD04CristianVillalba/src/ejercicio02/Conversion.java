package ejercicio02;

public class Conversion {

    public double convertirCelsiusAFarenheit(double celsius) throws TemperaturaLimitException{
        double result=0, tope=-273;
        result=(celsius * (9.0/5.0))+32;
        if (celsius<tope){
            throw new TemperaturaLimitException("Error, la temperatura no puede ser menor a -273");
        }else{
            return result;
        }
    }
}
