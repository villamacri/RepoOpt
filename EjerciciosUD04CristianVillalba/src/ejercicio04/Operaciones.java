package ejercicio04;

public class Operaciones {

    public double sumar(double a, double b) throws SumaLimitException{
        double result=0, tope =10;

        result=a+b;
        if(result > tope){
            throw new SumaLimitException("La suma no puede ser mayor a 10");
        }else {
            return result;
        }
    }
}
