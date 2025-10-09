package ejercicio10;

import java.util.List;

public class CalculadoraFiguras {

    public double calcularMediaAreas(List<Figura> figuras){
       double suma=0;
        for(Figura f : figuras){
            suma+=f.calcularArea();
        }
        return suma/figuras.size();
    }
}
